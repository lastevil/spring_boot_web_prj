package com.sproject.spring_boot_web_prj.repositorys;

import com.sproject.spring_boot_web_prj.model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements Repo {

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    @Override
    public List<Product> getProducts(){
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> productsList = (List<Product>) session.createQuery("SELECT p FROM Product p").getResultList();
            session.getTransaction().commit();
            return productsList;
        }

    }
    @Override
    public Product getProductById(Integer id){
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }
}
