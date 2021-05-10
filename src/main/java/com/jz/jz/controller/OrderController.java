package com.jz.jz.controller;

import com.jz.jz.service.OrderService;
import com.jz.jz.shoppingcart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody Order order){
        orderService.creatOrder(order);
    }

    @GetMapping("/getByOrderId")
    public Optional<Order> getByOrderId(@RequestParam("orderId") String orderId){
        return orderService.getByOrderId(orderId);
    }

    @RequestMapping("/getByVendorId")
    public List<Order> getByVendorId(@RequestParam("vendorId") String vendorId){
        return orderService.getByVendorId(vendorId);
    }

    @RequestMapping("/getByCustomerId")
    public List<Order> getByCustomerId(@RequestParam("customerId") String customerId){
        return orderService.getByCustomerId(customerId);
    }
}
