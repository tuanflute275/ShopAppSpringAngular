package vn.tuanflutte.services.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.OrderDetail;
import vn.tuanflutte.repositories.OrderDetailRepository;
import vn.tuanflutte.services.orderDetail.IOrderDetailService;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll(Sort.by(Sort.Direction.DESC, "orderDetailId"));
    }

    @Override
    public void save(OrderDetail orderDetail) {
        OrderDetail orderDetail1 = new OrderDetail(
                orderDetail.getOrderId(),
                orderDetail.getProductId(),
                orderDetail.getPrice(),
                orderDetail.getQuantity(),
                orderDetail.getTotalMoney()
        );
        orderDetailRepository.save(orderDetail1);
    }
}
