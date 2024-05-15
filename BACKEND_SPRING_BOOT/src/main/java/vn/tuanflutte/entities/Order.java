package vn.tuanflutte.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private int orderId;
    @Column(name = "OrderFullName")
    private String orderFullName;
    @Column(name = "OrderAddress")
    private String orderAddress;
    @Column(name = "OrderPhoneName")
    private String orderPhoneNumber;
    @Column(name = "OrderEmail")
    private String orderEmail;
    @Column(name = "OrderDate")
    private String orderDate;
    @Column(name = "OrderPaymentMethods")
    private String orderPaymentMethods;
    @Column(name = "OrderStatusPayment")
    private String orderStatusPayment;
    @Column(name = "OrderStatus")
    private int orderStatus;
    @Column(name = "OrderAmount")
    private double orderAmount;
    @Column(name = "OrderNote")
    private String orderNote;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    @JsonBackReference
    private Coupon coupon;

    public Order() {
    }

    public Order(String orderFullName, String orderAddress, String orderPhoneNumber, String orderEmail, String orderDate, String orderPaymentMethods, String orderStatusPayment, int orderStatus, double orderAmount, String orderNote, User user) {
        this.orderFullName = orderFullName;
        this.orderAddress = orderAddress;
        this.orderPhoneNumber = orderPhoneNumber;
        this.orderEmail = orderEmail;
        this.orderDate = orderDate;
        this.orderPaymentMethods = orderPaymentMethods;
        this.orderStatusPayment = orderStatusPayment;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.orderNote = orderNote;
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderFullName() {
        return orderFullName;
    }

    public void setOrderFullName(String orderFullName) {
        this.orderFullName = orderFullName;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhoneNumber() {
        return orderPhoneNumber;
    }

    public void setOrderPhoneNumber(String orderPhoneNumber) {
        this.orderPhoneNumber = orderPhoneNumber;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderPaymentMethods() {
        return orderPaymentMethods;
    }

    public void setOrderPaymentMethods(String orderPaymentMethods) {
        this.orderPaymentMethods = orderPaymentMethods;
    }

    public String getOrderStatusPayment() {
        return orderStatusPayment;
    }

    public void setOrderStatusPayment(String orderStatusPayment) {
        this.orderStatusPayment = orderStatusPayment;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
