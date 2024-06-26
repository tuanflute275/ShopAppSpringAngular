package vn.tuanflutte.services.blog;

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
import vn.tuanflutte.repositories.BlogRepository;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    private List<Blog> dataPDF;

    public BlogService(List<Blog> listData) {
        this.dataPDF = listData;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "blogId"));
    }

    @Override
    public List<Blog> findAllNoSort() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByTitle(String key) {
        return blogRepository.findByBlogTitle(key);
    }

    @Override
    public Optional<Blog> findById(Integer blogId) {
        return blogRepository.findById(blogId);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public boolean existsById(Integer blogId) {
        return blogRepository.existsById(blogId);
    }

    @Override
    public void deleteById(Integer blogId) {
        blogRepository.deleteById(blogId);
    }

    // pdf
    private void writeTableHeader(PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);

        BaseFont baseFont=BaseFont.createFont(getClass().getResource("/Arial.ttf").toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        com.lowagie.text.Font font=new com.lowagie.text.Font(baseFont, 12, Element.ALIGN_CENTER);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("STT", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tên tin tức", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Hình ảnh", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mô tả", font));
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
        for (Blog data : dataPDF) {
            table.addCell(createCellWithFont(String.valueOf(data.getBlogId())));
            table.addCell(createCellWithFont(data.getBlogTitle()));
            table.addCell(createImageCell(data.getBlogImage()));
            table.addCell(createCellWithFont(data.getBlogDescription()));
        }
    }


    private PdfPCell createCellWithFont(String content) throws IOException {
        BaseFont baseFont=BaseFont.createFont(getClass().getResource("/Arial.ttf").toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        com.lowagie.text.Font font=new com.lowagie.text.Font(baseFont, 12, com.lowagie.text.Font.NORMAL);
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
        com.lowagie.text.Font font=new com.lowagie.text.Font(baseFont, 20, Font.NORMAL);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Danh sách dữ liệu", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.0f, 2.0f, 1.6f, 3.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();

    }
}
