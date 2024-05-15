package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tuanflutte.entities.CouponCondition;

import java.util.List;

public interface CouponConditionRepository extends JpaRepository<CouponCondition, Integer> {
    List<CouponCondition> findByCouponId(Integer couponId);
}
