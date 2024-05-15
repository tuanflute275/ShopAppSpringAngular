package vn.tuanflutte.dtos.request;

public class OrderInput {
    private String orderFullName;
    private String orderAddress;
    private String orderPhoneNumber;
    private String orderEmail;
    private String orderDate;
    private String orderPaymentMethods;
    private String orderStatusPayment;
    private int orderStatus;
    private int orderAmount;
    private String orderNote;

    /*
    * 1. cho xac nhan
    * 2. xac nhan don hang
    * 3. chuan bi don hang
    * 4. dang giao hang
    * 5.da giao hang
    * 6. huy don hang
    *
    */

    public OrderInput() {
    }

    public OrderInput(String orderFullName, String orderAddress, String orderPhoneNumber, String orderEmail, String orderDate, String orderPaymentMethods, String orderStatusPayment, int orderStatus, int orderAmount, String orderNote) {
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

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }
}
