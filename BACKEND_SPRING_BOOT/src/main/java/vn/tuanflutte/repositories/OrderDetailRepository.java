package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tuanflutte.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
