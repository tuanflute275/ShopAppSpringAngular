package vn.tuanflutte.entities;

import javax.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "percent", nullable = false)
    private int percent;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "active", nullable = false)
    private int active;

    public Coupon() {
    }

    public Coupon(String code, int percent, String description, int active) {
        this.code = code;
        this.percent = percent;
        this.description = description;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
