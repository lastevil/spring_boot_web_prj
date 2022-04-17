package com.sproject.spring_boot_web_prj.controllers;

import com.sproject.spring_boot_web_prj.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    //главная страница http://127.0.0.1:8189/app/catalog
    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("products", productService.getProductList());
        model.addAttribute("cartCount", productService.getCartCount());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String addToCart(Model model, @PathVariable Integer id) {
        productService.addToCart(id);
        model.addAttribute("products", productService.getProductList());
        model.addAttribute("cartCount", productService.getCartCount());
        return "index";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("products", productService.getCart());
        model.addAttribute("cartPrice", productService.getCartSum());
        return "cart";
    }

    @GetMapping("/deleteFromCart/{id}")
    public String deleteFromCart(Model model, @PathVariable Integer id) {
        productService.deleteFromCart(id);
        model.addAttribute("products", productService.getCart());
        model.addAttribute("cartPrice", productService.getCartSum());
        return "cart";
    }
}
