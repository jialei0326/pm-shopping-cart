package com.jz.jz.service;

import com.jz.jz.shoppingcart.ShoppingCart;
import com.jz.jz.shoppingcart.ShoppingCartItem;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    //key: customerId, values: ShoppingCart
    private final Map<String, ShoppingCart> mockDB = new HashMap<>();

    @Override
    public void addProduct(String customerId, int productId, int quantity) {
        ShoppingCart cart;
        if(mockDB.containsKey(customerId)){
            cart = mockDB.get(customerId);
        }else{
            cart = new ShoppingCart();
            cart.setCartId(0);
            cart.setCustomerId(customerId);
        }

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setDateAdded(new Date());
        shoppingCartItem.setProductId(productId);
        shoppingCartItem.setQuantity(quantity);
        cart.getItems().put(productId, shoppingCartItem);

        // db or repository
        mockDB.put(customerId, cart);
    }

    @Override
    public void deleteProduct(String customerId, int productId) {
        ShoppingCart cart = mockDB.get(customerId);
        if(cart == null){
            return;
        }
        cart.getItems().remove(productId);
    }

    @Override
    public void updateQuantity(String customerId, int productId, int quantity) {
        ShoppingCart cart = mockDB.get(customerId);
        if(cart == null){
            return;
        }
        cart.getItems().get(productId).setQuantity(quantity);
    }

    @Override
    public String viewProduct(String customerId) {
        ShoppingCart cart = mockDB.get(customerId);
        return cart.getItems().toString();
    }


}
