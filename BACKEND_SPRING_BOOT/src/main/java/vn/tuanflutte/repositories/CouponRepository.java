package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tuanflutte.entities.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Optional<Coupon> findByCode(String couponCode);
}
