package vn.tuanflutte.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "coupon_conditions")
public class CouponCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int coupon_id;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Coupon coupon;

    @Column(name = "attribute", nullable = false)
    private String attribute;
    @Column(name = "operator", nullable = false)
    private String operator;
    @Column(name = "value", nullable = false)
    private String value;
    @Column(name = "discountAmount",nullable = false)
    private double discount_amount;

    public CouponCondition() {
    }

    public CouponCondition(String attribute, String operator, String value, double discount_amount) {
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
        this.discount_amount = discount_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }

    /*
       INSERT INTO coupons (id, code, percent, description, active) VALUES (1, 'TUANFLUTE275', 20,'Tối thiểu 150K', 1);
       INSERT INTO coupons (id, code, percent, description, active) VALUES (2, 'DISCOUNT10', 10,'Tối thiểu 127K', 1);

        INSERT INTO coupon_conditions (id, coupon_id, attribute, operator, value, discount_amount) VALUES
        (1, 1, 'minimum_amount', '>', 100000, 15);

        INSERT INTO coupon_conditions (id, coupon_id, attribute, operator, value, discount_amount) VALUES
        (1, 1, 'applicable_date', 'BETWEEN', 2024-5-27, 5);

        // điều kiện áp mã của mã DISCOUNT10
        INSERT INTO coupon_conditions (id, coupon_id, attribute, operator, value, discount_amount) VALUES
        (3, 2, 'minimum_amount', '>', 127500, 10);

        Nếu đơn hàng có tổng giá trị là 150000
        Giá trị sau khi áp mã TUANFLUTE275 giảm 15%:
        150000 * (1-15/100) = 127500
        Giá trị sau khi áp mã TUANFLUTE275 giảm 10%:
        127500 * (1-5/100) = 121125

    */

}
