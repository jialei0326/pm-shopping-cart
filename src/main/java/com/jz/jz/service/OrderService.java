package com.jz.jz.service;

import com.jz.jz.shoppingcart.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void creatOrder(Order order);
//    void creatOrder(Double subtotal, String shippingAddress);
    Optional<Order> getByOrderId(String orderId);
    List<Order> getByVendorId(String vendorId);
    List<Order> getByCustomerId(String customerId);
}
