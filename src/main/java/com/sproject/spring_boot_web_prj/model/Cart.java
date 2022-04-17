package com.sproject.spring_boot_web_prj.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> productList;

    public Cart() {
        productList = new ArrayList<>();
    }

    public void add(Product p) {
        productList.add(p);
    }

    public void delete(Integer id) {
        productList.stream()
                .filter(product -> product.getId().equals(id)).findFirst().
                ifPresent(productList::remove);
    }

    public List<Product> showCart() {
        return Collections.unmodifiableList(productList);
    }

    public double getSum() {
        if (productList.size() > 0) {
            return productList.stream()
                    .mapToDouble(p -> p.getCoast())
                    .sum();
        } else return 0;
    }

    public Integer getCount(){
        return productList.size();
    }
}
