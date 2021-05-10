package com.jz.jz.shoppingcart;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartItem {

    private Integer productId;
    private Integer quantity;
    private Date dateAdded;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
