package com.sproject.spring_boot_web_prj.services;

import com.sproject.spring_boot_web_prj.model.User;
import com.sproject.spring_boot_web_prj.repositorys.CartRepository;
import com.sproject.spring_boot_web_prj.model.Product;
import com.sproject.spring_boot_web_prj.repositorys.ProductRepository;
import com.sproject.spring_boot_web_prj.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    public Product findById(Integer id) {
        return productRepository.getProductById(id);
    }

    private Integer userIdEmu =1; // Пока нет страницы логина, эмулируем id user1

    public List getProductList() {
        return productRepository.getProducts();
    }

    public void addToCart(Integer id) {
        cartRepository.add(userIdEmu, productRepository.getProductById(id));
    }

    public void deleteFromCart(Integer id) {
        cartRepository.delete(userIdEmu, id);
    }

    public void deleteAllFromCArt(Integer id) {
        cartRepository.deleteAllbyId(userIdEmu, id);
    }

    public Double getCartSum() {
        return cartRepository.getSum(userIdEmu);
    }

    public List getCart() {
        return cartRepository.showCart(userIdEmu);
    }

    public Integer getCartCount() {
        return cartRepository.getCount(userIdEmu);
    }

    public User getUserByLogin(String login, String password) {
        return userRepository.userByLoginPassword(login,password);
    }
}
