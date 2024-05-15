package vn.tuanflutte.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.configuration.JwtRequestFilter;
import vn.tuanflutte.dtos.request.OrderInput;
import vn.tuanflutte.entities.*;
import vn.tuanflutte.repositories.*;
import vn.tuanflutte.services.cart.CartService;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public void save(OrderInput orderInput){
        String currentUser = JwtRequestFilter.CURRENT_USER;
        User user = userRepository.findById(currentUser).get();
        List<Cart> carts = cartService.getCart();
        Order order = new Order(
                orderInput.getOrderFullName(),
                orderInput.getOrderAddress(),
                orderInput.getOrderPhoneNumber(),
                orderInput.getOrderEmail(),
                orderInput.getOrderDate(),
                orderInput.getOrderPaymentMethods(),
                orderInput.getOrderStatusPayment(),
                orderInput.getOrderStatus(),
                orderInput.getOrderAmount(),
                orderInput.getOrderNote(),

                user
        );
        orderRepository.save(order);

        // luu thong tin san pham vao orderDetail
        Order orderOne = orderRepository.findByOrderEmail(orderInput.getOrderEmail());
        for (Cart c: carts){
            OrderDetail orderDetail1 = new OrderDetail(
                    orderOne.getOrderId(),
                    c.getProduct().getProductId(),
                    c.getProduct().getProductSalePrice() > 0 ? c.getProduct().getProductSalePrice() : c.getProduct().getProductPrice(),
                    c.getQuantity(),
                    c.getTotalAmount()
            );
            orderDetailRepository.save(orderDetail1);
        }

        //xoa thong tin trong bang cart
        for (Cart c: carts){
            cartService.deleteById(c.getCartId());
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderId"));
    }

    @Override
    public List<Order> findAllByUser() {
        String username = JwtRequestFilter.CURRENT_USER;
        User user = userRepository.findById(username).get();
        return orderRepository.findByUser(user);
    }

    @Override
    public List<Order> findByOrderPhoneNumber(String orderPhoneNumber) {
        return orderRepository.findByOrderPhoneNumber(orderPhoneNumber);
    }

    @Override
    public Optional<Order> findById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    @Transactional
    public void updateStatus(int orderId, int status) {
        Order order = orderRepository.getOne(orderId);;
        order.setOrderStatus(status);
        if (status == 5){
            order.setOrderStatusPayment("Đã thanh toán");
        }else {
            order.setOrderStatusPayment("Chưa thanh toán");
        }
        orderRepository.save(order);
    }

    @Override
    public boolean existsById(Integer orderId) {
        return orderRepository.existsById(orderId);
    }

    @Override
    public void deleteById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
