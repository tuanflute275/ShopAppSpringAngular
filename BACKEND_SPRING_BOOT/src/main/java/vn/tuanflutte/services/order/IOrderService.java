package vn.tuanflutte.services.order;

import vn.tuanflutte.entities.Order;
import vn.tuanflutte.dtos.request.OrderInput;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    public List<Order> findAll();
    public List<Order> findAllByUser();
    public List<Order> findByOrderPhoneNumber(String orderPhoneNumber);
    public Optional<Order> findById(Integer orderId);
    public void save(OrderInput orderInput);
    public void updateStatus(int orderId, int status);
    public boolean existsById(Integer orderId);
    public void deleteById(Integer orderId);
}
