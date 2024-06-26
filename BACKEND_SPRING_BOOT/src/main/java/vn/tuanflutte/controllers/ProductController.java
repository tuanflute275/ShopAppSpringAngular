package vn.tuanflutte.controllers;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.tuanflutte.dtos.response.ProductDTO;
import vn.tuanflutte.entities.Category;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.category.CategoryService;
import vn.tuanflutte.services.product.IProductService;
import vn.tuanflutte.services.product.ProductService;
import vn.tuanflutte.services.uploadFile.IUploadFileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    ResponseEntity<ResponseObject> getAllProduct(@RequestParam(defaultValue = "") String key){
        List<Product> list = null;
        if (key.equals("")){
            list = productService.findAll();
        }else {
            list = productService.findByName(key);
            if(list.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "No Data", "")
                );
            }
        }

        List<ProductDTO> listDTO = new ArrayList<>();
        for (Product p : list){
            ProductDTO dto = new ProductDTO();
            dto.setProductId(p.getProductId());
            dto.setProductName(p.getProductName());
            dto.setProductImage(p.getProductImage());
            dto.setProductPrice(p.getProductPrice());
            dto.setProductSalePrice(p.getProductSalePrice());
            dto.setProductCategoryId(p.getProductCategoryId());
            dto.setProductCategoryName(p.getCategory().getCategoryName());
            dto.setProductStatus(p.getProductStatus());
            dto.setProductDescription(p.getProductDescription());
            listDTO.add(dto);
        }

        if(list.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query product successfully", listDTO)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }

    }

    @GetMapping("/{productId}")
    ResponseEntity<ResponseObject> findById(@PathVariable int productId){
        Optional<Product> foundProduct = productService.findById(productId);
        List<ProductDTO> listDTO = new ArrayList<>();
            ProductDTO dto = new ProductDTO();
            dto.setProductId(foundProduct.get().getProductId());
            dto.setProductName(foundProduct.get().getProductName());
            dto.setProductImage(foundProduct.get().getProductImage());
            dto.setProductPrice(foundProduct.get().getProductPrice());
            dto.setProductSalePrice(foundProduct.get().getProductSalePrice());
            dto.setProductCategoryId(foundProduct.get().getProductCategoryId());
            dto.setProductCategoryName(foundProduct.get().getCategory().getCategoryName());
            dto.setProductStatus(foundProduct.get().getProductStatus());
            dto.setProductDescription(foundProduct.get().getProductDescription());
            listDTO.add(dto);

        if(foundProduct.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query product successfully", listDTO)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find product with id = "+productId, "")
            );
        }
    }

    @GetMapping("/discount")
    ResponseEntity<ResponseObject> getProductAndLimit(){
        List<Product> list = productService.findProductDiscount();
        List<ProductDTO> listDTO = new ArrayList<>();

        for (Product p : list){
            ProductDTO dto = new ProductDTO();
            dto.setProductId(p.getProductId());
            dto.setProductName(p.getProductName());
            dto.setProductImage(p.getProductImage());
            dto.setProductPrice(p.getProductPrice());
            dto.setProductSalePrice(p.getProductSalePrice());
            dto.setProductId(p.getProductCategoryId());
            dto.setProductCategoryName(p.getCategory().getCategoryName());
            dto.setProductStatus(p.getProductStatus());
            dto.setProductDescription(p.getProductDescription());
            listDTO.add(dto);
        }

        if(list.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query product successfully", listDTO)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }

    }

    @GetMapping("/{productId}/{categoryId}")
    ResponseEntity<ResponseObject> getProductByCategory(@PathVariable int productId, @PathVariable int categoryId) {
        List<Product> list = productService.findByCategory(productId, categoryId);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Query product successfully", list)
        );
    }

    @PostMapping("")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", productService.save(newProduct))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", "")
            );
        }
    }

    @PutMapping("/{productId}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable int productId){
        Product updateProduct = productService.findById(productId)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setProductImage(newProduct.getProductImage());
                    product.setProductPrice(newProduct.getProductPrice());
                    product.setProductSalePrice(newProduct.getProductSalePrice());
                    product.setProductCategoryId(newProduct.getProductCategoryId());
                    product.setProductDescription(newProduct.getProductDescription());
                    product.setProductStatus(newProduct.getProductStatus());
                    return productService.save(product);
                }).orElseGet(()->{
                    newProduct.setProductId(productId);
                    return productService.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfuly", updateProduct)
        );
    }

    @DeleteMapping("/{productId}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable int productId){
        boolean exits = productService.existsById(productId);
        if(exits){
            productService.deleteById(productId);
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
        String headerValue = "attachment; filename=product_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Product> listData = productService.findAllNoSort();

        ProductService exporter = new ProductService(listData);
        exporter.export(response);
    }
}
