package vn.tuanflutte.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.repositories.ProductRepository;
import vn.tuanflutte.services.product.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public List<Product> findByName(String key) {
        return productRepository.findByProductName(key);
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

    //    @PostMapping(value = {""})
//    public Product addNewProduct(@RequestBody Product product){
//        return this.productService.addNewProduct(product);
//    }

//    @PostMapping(value = {""}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Product addNewProduct(@RequestPart("product") Product product,
//                                 @RequestPart("imageFile")MultipartFile[] file){
//        try {
//            Set<ImageModel> images = uploadImage(file);
//            product.setProductImages(images);
//            repository.save(product);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//        return product;
//    }


//    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
//        Set<ImageModel> imageModels = new HashSet<>();
//        for(MultipartFile file: multipartFiles){
//            ImageModel imageModel = new ImageModel(
//                    file.getOriginalFilename(),
//                    file.getContentType(),
//                    file.getBytes()
//            );
//            imageModels.add(imageModel);
//        }
//        return imageModels;
//    }
}
