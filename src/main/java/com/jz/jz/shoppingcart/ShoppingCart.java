package com.jz.jz.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private int cartId;
    private String customerId;
    // key: product id, value: ShoppingCartItem
    private Map<Integer, ShoppingCartItem> items = new HashMap<>();

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<Integer, ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, ShoppingCartItem> items) {
        this.items = items;
    }
}
