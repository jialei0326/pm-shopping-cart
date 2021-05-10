package com.jz.jz.accessingdatamysql;

import com.jz.jz.shoppingcart.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {
    List<Order> findByVendorId(String vendorId);
    List<Order> findByCustomerId(String customerId);
}
