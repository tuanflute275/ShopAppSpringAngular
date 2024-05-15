package vn.tuanflutte.services.cart;

import vn.tuanflutte.entities.Cart;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.entities.User;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    public Cart addToCart(Integer productId, Integer quantity);
    public Cart updateToCart(Integer cartId,Integer productId, Integer quantity, Integer totalAmount);
    public List<Cart> getCart();
    public Optional<Cart> findById(Integer cartId);
    public boolean existsById(Integer cartId);
    public void deleteById(Integer cartId);
    public void updateQuantity(Integer cartId);
}
