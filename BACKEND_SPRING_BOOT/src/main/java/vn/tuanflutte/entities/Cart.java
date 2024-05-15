package vn.tuanflutte.entities;

import javax.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private int quantity;
    private int totalAmount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    public Cart() {
    }

    public Cart(int quantity,int totalAmount, Product product, User user) {
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.product = product;
        this.user = user;
    }


    public Cart(int cartId, int quantity, int totalAmount, Product product, User user) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.product = product;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
