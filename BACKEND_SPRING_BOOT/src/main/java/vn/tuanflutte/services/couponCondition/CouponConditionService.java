package vn.tuanflutte.services.couponCondition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.CouponCondition;
import vn.tuanflutte.repositories.CouponConditionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CouponConditionService implements ICouponConditionService {
    @Autowired
    private CouponConditionRepository couponConditionRepository;


    @Override
    public List<CouponCondition> findAll() {
        return couponConditionRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public CouponCondition save(CouponCondition condition) {
        return couponConditionRepository.save(condition);
    }

    @Override
    public Optional<CouponCondition> findById(Integer couponConditionId) {
        return couponConditionRepository.findById(couponConditionId);
    }

    @Override
    public void update(int couponConditionId, CouponCondition condition) {
        CouponCondition couponCondition = couponConditionRepository.getOne(couponConditionId);
        couponCondition.setCoupon_id(couponCondition.getCoupon_id());
        couponCondition.setAttribute(condition.getAttribute());
        couponCondition.setOperator(condition.getOperator());
        couponCondition.setValue(condition.getValue());
        couponCondition.setDiscount_amount(condition.getDiscount_amount());
        couponConditionRepository.save(couponCondition);
    }

    @Override
    public boolean existsById(Integer couponConditionId) {
        return couponConditionRepository.existsById(couponConditionId);
    }

    @Override
    public void deleteById(Integer couponConditionId) {
        couponConditionRepository.deleteById(couponConditionId);
    }
}
