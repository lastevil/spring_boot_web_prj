package com.sproject.spring_boot_web_prj.repositorys;

import com.sproject.spring_boot_web_prj.model.Product;
import com.sproject.spring_boot_web_prj.model.User;
import org.apache.commons.math3.util.Precision;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class CartRepository {

    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    public void add(Integer userId, Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, userId);
            user.getProductList().add(product);
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    public void delete(Integer userId, Integer productId) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, userId);
            user.getProductList().stream()
                    .filter(product -> product.getId().equals(productId)).findFirst().
                    ifPresent(user.getProductList()::remove);
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    public void deleteAllbyId(Integer userId, Integer productId) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, userId);
            user.getProductList().removeAll(user.getProductList().stream()
                    .filter(p -> p.getId().equals(productId))
                    .collect(Collectors.toList())
            );
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    public List showCart(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, id);
            List<Product> productList = user.getProductList();
            session.getTransaction().commit();
            return productList;
        }
    }

    public double getSum(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, id);
            List<Product> productList = user.getProductList();
            session.getTransaction().commit();
            if (productList.size() > 0) {
                return Precision.round(productList.stream()
                        .mapToDouble(p -> p.getCoast())
                        .sum(), 1);
            } else return 0;
        }
    }

    public Integer getCount(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, id);
            Integer size = user.getProductList().size();
            session.getTransaction().commit();
            return size;
        }
    }
}
