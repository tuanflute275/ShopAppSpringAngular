package vn.tuanflutte.controllers;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuanflutte.entities.Category;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.category.CategoryService;
import vn.tuanflutte.services.category.ICategoryService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    ResponseEntity<ResponseObject> getAllCategory(@RequestParam(defaultValue = "") String key){
        List<Category> list = null;
        if (key.equals("")){
             list = categoryService.findAll();
        }else {
            list = categoryService.findByName(key);
            if(list.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "No Data", "")
                );
            }
        }

        if(!list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query category successfully", list)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("/{categoryId}")
        //let's return an object with : data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable int categoryId){
        Optional<Category> foundCategory = categoryService.findById(categoryId);
        if(foundCategory.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query category successfully", foundCategory)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find category with id = "+categoryId, "")
            );
        }
    }

    @PostMapping("")
    ResponseEntity<ResponseObject> insertCategory(@RequestBody Category newCategory){
        //check unique
        List<Category> foundCategory = categoryService.findByName(newCategory.getCategoryName().trim());
        try {
           if(foundCategory.size() > 0){
               return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                       new ResponseObject("error", "Category name already taken", "")
               );
           }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", categoryService.save(newCategory))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", "")
            );
        }
    }

    @PutMapping("/{categoryId}")
    ResponseEntity<ResponseObject> updateCategory(@RequestBody Category newCategory, @PathVariable int categoryId){
        Category updateCategory = categoryService.findById(categoryId)
                .map(category -> {
                    category.setCategoryName(newCategory.getCategoryName());
                    category.setCategoryStatus(newCategory.getCategoryStatus());
                    return categoryService.save(category);
                }).orElseGet(()->{
                    newCategory.setCategoryId(categoryId);
                    return categoryService.save(newCategory);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfuly", updateCategory)
        );
    }

    @DeleteMapping("/{categoryId}")
    ResponseEntity<ResponseObject> deleteCategory(@PathVariable int categoryId){
        boolean exits = categoryService.existsById(categoryId);
        if(exits){
            categoryService.deleteById(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete data successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find data to delete", "")
        );
    }

    @GetMapping("/download")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=category_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Category> listData = categoryService.findAllNoSort();

        CategoryService exporter = new CategoryService(listData);
        exporter.export(response);
    }

}
