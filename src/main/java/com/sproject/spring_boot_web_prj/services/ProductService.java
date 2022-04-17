package com.sproject.spring_boot_web_prj.services;

import com.sproject.spring_boot_web_prj.model.Cart;
import com.sproject.spring_boot_web_prj.model.Product;
import com.sproject.spring_boot_web_prj.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Cart cart;

    public Product findById(Integer id) {
        return productRepository.getProductById(id);
    }

    public List getProductList() {
        return productRepository.getProducts();
    }

    public void addToCart(Integer id) {
        cart.add(productRepository.getProductById(id));
    }

    public void deleteFromCart(Integer id) {
        cart.delete(id);
    }

    public double getCartSum(){
        return cart.getSum();
    }

    public List getCart(){
        return cart.showCart();
    }
    public Integer getCartCount(){
        return cart.getCount();
    }
}
