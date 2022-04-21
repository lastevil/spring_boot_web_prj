package com.sproject.spring_boot_web_prj.repositorys;

import com.sproject.spring_boot_web_prj.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository implements Repo {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(List.of(
                new Product(1,"First",1.1),
                new Product(2,"Second",2.2),
                new Product(3,"Third",3.3),
                new Product(4,"Fourth",4.4),
                new Product(5,"Fifth",5.5)
        ));
    }

    @Override
    public List<Product> getProducts(){
        return Collections.unmodifiableList(productList);
    }
    @Override
    public Product getProductById(Integer id){
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->new RuntimeException("Product not found"));
    }
}
