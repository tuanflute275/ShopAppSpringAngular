package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tuanflutte.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByProductName(String key);

    @Query("select u from Product u where u.productId not in (?1) and u.productCategoryId=?2 ORDER BY RAND ()")
    List<Product> findByCategory(Integer productId,Integer categoryId);

    @Query(value = "select u from Product u where u.productSalePrice > 0 ORDER BY RAND ()")
    List<Product> findProductDiscount();

    @Query("select u from Product u where u.productName like %?1% ORDER BY productName DESC")
    List<Product> searchProduct(String keyword);
}