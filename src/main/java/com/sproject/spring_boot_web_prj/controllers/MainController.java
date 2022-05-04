package com.sproject.spring_boot_web_prj.controllers;
import com.sproject.spring_boot_web_prj.model.User;
import com.sproject.spring_boot_web_prj.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("/login")
    public User login(@RequestParam String login, @RequestParam String password){
        return productService.getUserByLogin(login,password);
    }

    @GetMapping("/catalog")
    public List catalog() {
        return productService.getProductList();
    }

    @GetMapping("/cartcount")
    public Integer cartcount() {
        return productService.getCartCount();
    }

    @GetMapping("/cartList")
    public List showCart() {
        return productService.getCart();
    }

    @GetMapping("/cart_price")
    public Double cartprice() {
        return productService.getCartSum();
    }

    @GetMapping("/toCart")
    public void addToCart(@RequestParam Integer id) {
        productService.addToCart(id);
    }

    @GetMapping("/deleteFromCart")
    public void deleteFromCart(@RequestParam Integer id) {
        productService.deleteFromCart(id);
    }

    @GetMapping("/deleteAllFromCart")
    public void deleteAllFromCart(@RequestParam Integer id) {
        productService.deleteAllFromCArt(id);
    }
}
