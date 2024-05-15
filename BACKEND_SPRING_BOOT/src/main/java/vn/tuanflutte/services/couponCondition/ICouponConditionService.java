package vn.tuanflutte.services.couponCondition;

import vn.tuanflutte.entities.CouponCondition;

import java.util.List;
import java.util.Optional;

public interface ICouponConditionService {
    public List<CouponCondition> findAll();
    public CouponCondition save(CouponCondition condition);
    public Optional<CouponCondition> findById(Integer couponConditionId);
    public void update(int couponConditionId, CouponCondition condition);
    public boolean existsById(Integer couponConditionId);
    public void deleteById(Integer couponConditionId);
}
