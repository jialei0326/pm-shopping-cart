package com.jz.jz.service;

import com.jz.jz.accessingdatamysql.OrderRepository;
import com.jz.jz.shoppingcart.Order;
import com.jz.jz.shoppingcart.OrderItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void creatOrder(Order order) {
        Order o = new Order();
        o.setCustomerId(order.getCustomerId());
        o.setCreateDate(new Date());
//        o.setPaymentInfo(order.getPaymentInfo());
        o.setVendorId(order.getVendorId());
        o.setShippingAddress(order.getShippingAddress());
        List<OrderItemDetail> list = order.getOrderItemDetailsList();
        o.setOrderItemDetailsList(list);

        o.setSubtotal(order.calSubtotal(list));
        orderRepository.save(o);
    }

    @Override
    public Optional<Order> getByOrderId(String orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public List<Order> getByVendorId(String vendorId) {
        return orderRepository.findByVendorId(vendorId);
    }

    @Override
    public List<Order> getByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
