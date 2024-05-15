package vn.tuanflutte.services.coupon;

import vn.tuanflutte.entities.Coupon;

import java.util.List;
import java.util.Optional;

public interface ICouponService {
    double caculateCouponValue(String couponCode, double totalAmount);
    public List<Coupon> findAll();
    public Coupon save(Coupon coupon);
    public Optional<Coupon> findById(Integer couponId);
    public void update(int couponId, Coupon coupon);
    public boolean existsById(Integer couponId);
    public void deleteById(Integer couponId);
}
