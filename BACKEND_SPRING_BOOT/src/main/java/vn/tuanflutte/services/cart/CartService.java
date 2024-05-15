package vn.tuanflutte.services.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuanflutte.configuration.JwtRequestFilter;
import vn.tuanflutte.entities.Cart;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.entities.User;
import vn.tuanflutte.repositories.CartRepository;
import vn.tuanflutte.repositories.ProductRepository;
import vn.tuanflutte.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    public Cart addToCart(Integer productId, Integer quantity){
        Product product = productRepository.findById(productId).get();
        String userName = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if(userName != null){
            user = userRepository.findById(userName).get();
        }

        if(product != null && user != null){
            Cart cart = new Cart(quantity,
                    (int) (product.getProductSalePrice() > 0 ? product.getProductSalePrice() : product.getProductPrice()) * quantity
                    ,product, user);
            cartRepository.save(cart);
            return cart;
        }
        return null;
    }

    public Cart updateToCart(Integer cartId,Integer productId, Integer quantity, Integer totalAmount){
        Product product = productRepository.findById(productId).get();
        String userName = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if(userName != null){
            user = userRepository.findById(userName).get();
        }
        if(product != null && user != null){
            Cart cart = new Cart(cartId, quantity, totalAmount ,product, user);
            cartRepository.save(cart);
            return cart;
        }
        return null;
    }

    public List<Cart> getCart(){
        String username = JwtRequestFilter.CURRENT_USER;
        User user = userRepository.findById(username).get();
        return cartRepository.findByUser(user);
    }

    @Override
    public Optional<Cart> findById(Integer cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public boolean existsById(Integer cartId) {
        return cartRepository.existsById(cartId);
    }

    @Override
    public void deleteById(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public void updateQuantity(Integer cartId) {
        Cart cart = cartRepository.getOne(cartId);
        cart.setQuantity(cart.getQuantity() + 1);
        cartRepository.save(cart);
        cart.setTotalAmount((int) (cart.getProduct().getProductSalePrice() > 0 ? cart.getProduct().getProductSalePrice() : cart.getProduct().getProductPrice()) * cart.getQuantity());
        cartRepository.save(cart);
    }
}
