package vn.tuanflutte.services.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.Coupon;
import vn.tuanflutte.entities.CouponCondition;
import vn.tuanflutte.repositories.CouponConditionRepository;
import vn.tuanflutte.repositories.CouponRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService implements ICouponService{
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CouponConditionRepository couponConditionRepository;

    @Override
    public List<Coupon> findAll() {
        return couponRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Coupon save(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Optional<Coupon> findById(Integer couponId) {
        return couponRepository.findById(couponId);
    }

    @Override
    public void update(int couponId, Coupon coupon) {
        Coupon couponUpdate = couponRepository.getOne(couponId);
        couponUpdate.setCode(coupon.getCode());
        couponUpdate.setPercent(coupon.getPercent());
        couponUpdate.setDescription(coupon.getDescription());
        couponUpdate.setActive(coupon.getActive());
        couponRepository.save(couponUpdate);

    }

    @Override
    public boolean existsById(Integer couponId) {
        return couponRepository.existsById(couponId);
    }

    @Override
    public void deleteById(Integer couponId) {
        couponRepository.deleteById(couponId);
    }

    @Override
    public double caculateCouponValue(String couponCode, double totalAmount) {
        Coupon coupon = couponRepository.findByCode(couponCode)
                .orElseThrow(()->new IllegalArgumentException("Coupon not found"));
        if(coupon.getActive() != 1){
            throw new IllegalArgumentException("Coupon is not active");
        }
        double discount = caculateDiscount(coupon, totalAmount);
        double finalAmount = totalAmount - discount;
        return finalAmount;
    }

    private double caculateDiscount(Coupon coupon, double totalAmount) {
        List<CouponCondition> conditions = couponConditionRepository.findByCouponId(coupon.getId());
        double discount = 0.0;
        double updatedTotalAmount = totalAmount;
        for (CouponCondition condition: conditions){
            String attribute = condition.getAttribute();
            String operator = condition.getOperator();
            String value = condition.getValue();

            double percentDiscount = Double.valueOf(String.valueOf(condition.getDiscount_amount()));

            if(attribute.equals("minimum_amount")){
                if(operator.equals(">") && updatedTotalAmount > Double.parseDouble(value)){
                    discount += updatedTotalAmount * percentDiscount / 100;
                }
            }
            else if(attribute.equals("applicable_date")){
                LocalDate applicableDate = LocalDate.parse(value);
                LocalDate currentDate = LocalDate.now();
                if(operator.equalsIgnoreCase("BETWEEN") && currentDate.isEqual(applicableDate)){
                    discount += updatedTotalAmount * percentDiscount / 100;
                }
            }
            // nhiều điều kiện khác
            updatedTotalAmount = updatedTotalAmount - discount;
        }
        return discount;
    }
}
