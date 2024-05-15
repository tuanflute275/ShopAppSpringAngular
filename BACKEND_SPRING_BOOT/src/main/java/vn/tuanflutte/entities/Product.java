package vn.tuanflutte.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "ProductImage")
    private String productImage;
    @Column(name = "ProductPrice")
    private double productPrice;
    @Column(name = "ProductSalePrice")
    private double productSalePrice;
    @Column(name = "ProductCategoryId")
    private int productCategoryId;
    @Column(name = "ProductDescription")
    private String productDescription;
    @Column(name = "ProductStatus")
    private int productStatus;

    @ManyToOne
    @JoinColumn(name = "productCategoryId", referencedColumnName = "categoryId", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;


    public Product() {
    }

    public Product(String productName, String productImage, double productPrice, double productSalePrice, int productCategoryId, String productDescription, int productStatus) {
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productSalePrice = productSalePrice;
        this.productCategoryId = productCategoryId;
        this.productDescription = productDescription;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(double productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
