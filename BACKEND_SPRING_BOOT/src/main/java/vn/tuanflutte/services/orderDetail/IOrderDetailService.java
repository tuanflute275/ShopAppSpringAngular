package vn.tuanflutte.services.orderDetail;

import vn.tuanflutte.entities.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    public List<OrderDetail> findAll();
    public void save(OrderDetail orderDetail);
}
