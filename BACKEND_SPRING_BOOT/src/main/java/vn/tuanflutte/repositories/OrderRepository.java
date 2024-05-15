package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tuanflutte.entities.Cart;
import vn.tuanflutte.entities.Order;
import vn.tuanflutte.entities.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    public List<Order> findByOrderPhoneNumber(String orderPhoneNumber);
    public List<Order> findByUser(User user);
    public Order findByOrderEmail(String orderEmail);
}
