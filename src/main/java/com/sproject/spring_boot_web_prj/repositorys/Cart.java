package com.sproject.spring_boot_web_prj.repositorys;

import com.sproject.spring_boot_web_prj.model.CartProduct;
import com.sproject.spring_boot_web_prj.model.Product;
import org.apache.commons.math3.util.Precision;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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

    public void deleteAllbyId(Integer id) {
        productList.removeAll(productList.stream()
                .filter(p -> p.getId().equals(id))
                .collect(Collectors.toList())
        );
    }

    public List showCart() {
        if (productList.size() > 0) {
            Map<Product, Integer> products = productList.stream().collect(Collectors.toMap(
                    x -> x, value -> 1, Integer::sum
            ));
            ArrayList<CartProduct> a = new ArrayList<>();
            for (Map.Entry<Product, Integer> entery : products.entrySet()) {
                a.add(new CartProduct(
                        entery.getKey().getId(),
                        entery.getKey().getTitle(),
                        entery.getKey().getCoast(),
                        entery.getValue()
                ));
            }
            return a;
        } else
            return Collections.unmodifiableList(productList);
    }

    public double getSum() {
        if (productList.size() > 0) {
            return Precision.round(productList.stream()
                    .mapToDouble(p -> p.getCoast())
                    .sum(),1);
        } else return 0;
    }

    public Integer getCount() {
        return productList.size();
    }
}
