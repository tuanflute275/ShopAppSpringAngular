package vn.tuanflutte.services.product;

import vn.tuanflutte.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> findAll();
    public List<Product> findByName(String key);
    public Optional<Product> findById(Integer productId);
    public Product save(Product product);
    public boolean existsById(Integer productId);
    public void deleteById(Integer productId);
    public List<Product> findProductDiscount();
    public List<Product> findByCategory(Integer productId,Integer categoryId);
}
