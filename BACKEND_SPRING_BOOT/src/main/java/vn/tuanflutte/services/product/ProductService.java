package vn.tuanflutte.services.product;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.Blog;
import vn.tuanflutte.entities.Category;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.repositories.ProductRepository;
import vn.tuanflutte.services.product.IProductService;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    private List<Product> dataPDF;

    public ProductService(List<Product> listData) {
        this.dataPDF = listData;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public List<Product> findAllNoSort() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String key) {
        return productRepository.searchProduct(key);
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean existsById(Integer productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public void deleteById(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> findProductDiscount() {
        return productRepository.findProductDiscount();
    }

    @Override
    public List<Product> findByCategory(Integer productId, Integer categoryId) {
        return productRepository.findByCategory(productId, categoryId);
    }


    // pdf
    private void writeTableHeader(PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);

        BaseFont baseFont=BaseFont.createFont(getClass().getResource("/Arial.ttf").toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font=new Font(baseFont, 12, Element.ALIGN_CENTER);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("STT", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Hình ảnh", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tên sản phẩm", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Giá sản phẩm", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Trạng thái", font));
        table.addCell(cell);

    }

    private PdfPCell createImageCell(String imagePath) throws BadElementException, MalformedURLException, IOException {
        Image img = Image.getInstance(imagePath);
        img.scaleToFit(90, 90); // Adjust the size as needed
        PdfPCell cell = new PdfPCell(img);
        cell.setPadding(5);
        return cell;
    }

    private void writeTableData(PdfPTable table) throws IOException {
        for (Product data : dataPDF) {
            table.addCell(createCellWithFont(String.valueOf(data.getProductId())));
            table.addCell(createImageCell(data.getProductImage()));
            table.addCell(createCellWithFont(data.getProductName()));
            table.addCell(createCellWithFont(String.valueOf(data.getProductSalePrice() > 0 ? data.getProductSalePrice() : data.getProductPrice())));
            table.addCell(createCellWithFont(data.getProductStatus() == 1 ? "Show" : "Hide"));
        }
    }


    private PdfPCell createCellWithFont(String content) throws IOException {
        BaseFont baseFont=BaseFont.createFont(getClass().getResource("/Arial.ttf").toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font=new Font(baseFont, 12,Font.NORMAL);
        font.setColor(Color.BLACK);

        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setPadding(5);
        return cell;
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        BaseFont baseFont=BaseFont.createFont(getClass().getResource("/Arial.ttf").toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font=new Font(baseFont, 20,Font.NORMAL);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Danh sách dữ liệu", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {0.8f, 1.6f, 4.0f, 1.2f, 1.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();

    }

}
