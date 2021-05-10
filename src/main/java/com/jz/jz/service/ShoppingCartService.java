package com.jz.jz.service;

import java.util.Date;

public interface ShoppingCartService {
    void addProduct(String customerId, int productId, int quantity);
    void deleteProduct(String customerId, int productId);
    void updateQuantity(String customerId, int productId, int quantity);
    String viewProduct(String customerId);
}
