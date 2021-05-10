package com.jz.jz.shoppingcart;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "shoppingOrder")
public class Order {

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
    private String orderId;
    // is paid
    private boolean status;
    //key: productId, value: quantity
    private String customerId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItemDetail> orderItemDetailsList = new ArrayList<>();
    private String shippingAddress;
    private Date createDate;
    private double subtotal;
//    @OneToOne
//    private Payment paymentInfo;
    private String vendorId;

//    private Integer orderId;
//    private String customerId;
//    private String firstName;
//    private String lastName;
//    private String shippingAddress;
//    private double subtotal;
//    private String phoneNumber;
//    private String email;

    public double calSubtotal(List<OrderItemDetail> orderItemDetailsList){
        double subtotal = 0;
        for (OrderItemDetail item: orderItemDetailsList) {
            subtotal += item.getQuantity() * item.getPrice();
        }
        return subtotal;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getVendorId() {
        return vendorId;
    }

    public List<OrderItemDetail> getOrderItemDetailsList() {
        return orderItemDetailsList;
    }

    public void setOrderItemDetailsList(List<OrderItemDetail> orderItemDetailsList) {
        this.orderItemDetailsList = orderItemDetailsList;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
