package vn.tuanflutte.dtos.response;

import javax.persistence.Column;

public class ProductDTO {
    private int productId;
    private String productName;
    private String productImage;
    private double productPrice;
    private double productSalePrice;
    private int productCategoryId;
    private String productDescription;
    private int productStatus;
    private String productCategoryName;


    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName, String productImage, double productPrice, double productSalePrice, int productCategoryId, String productDescription, int productStatus, String productCategoryName) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productSalePrice = productSalePrice;
        this.productCategoryId = productCategoryId;
        this.productDescription = productDescription;
        this.productStatus = productStatus;
        this.productCategoryName = productCategoryName;
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

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
}
