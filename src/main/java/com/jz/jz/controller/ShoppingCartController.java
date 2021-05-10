package com.jz.jz.controller;

import com.jz.jz.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/addProduct")
    public void addToCart(@RequestParam("customerId") String customerId, @RequestParam("productId")int productId, @RequestParam("quantity")int quantity){
        shoppingCartService.addProduct(customerId, productId, quantity);
    }

    @RequestMapping("/deleteProduct")
    public void delete(@RequestParam("customerId") String customerId, @RequestParam("productId") int productId){
        shoppingCartService.deleteProduct(customerId, productId);
    }
    @RequestMapping("/updateQuantity")
    public void updateQuantity(@RequestParam("customerId") String customerId, @RequestParam("productId") int productId, @RequestParam("quantity") int quantity){
        shoppingCartService.updateQuantity(customerId, productId, quantity);
    }

    @GetMapping("/viewDetails/{customerId}")
    public String viewDetails(@PathVariable("customerId") String customerId){
        return shoppingCartService.viewProduct(customerId);
    }
//    @RequestMapping("checkout")

}
