package vn.tuanflutte.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.Category;
import vn.tuanflutte.repositories.CategoryRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.awt.Color;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import javax.servlet.http.HttpServletResponse;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private List<Category> dataPDF;

    public CategoryService(List<Category> listData) {
        this.dataPDF = listData;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "categoryId"));
    }

    @Override
    public List<Category> findAllNoSort() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findByName(String key) {
        return categoryRepository.findByCategoryName(key);
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean existsById(Integer categoryId) {
        return categoryRepository.existsById(categoryId);
    }

    @Override
    public void deleteById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
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

        cell.setPhrase(new Phrase("Tên danh mục", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Trạng thái", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) throws IOException {
        for (Category data : dataPDF) {
            table.addCell(createCellWithFont(String.valueOf(data.getCategoryId())));
            table.addCell(createCellWithFont(data.getCategoryName()));
            table.addCell(createCellWithFont(data.getCategoryStatus() == 1 ? "Show" : "Hide"));
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

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 4.0f, 1.7f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();

    }
}
