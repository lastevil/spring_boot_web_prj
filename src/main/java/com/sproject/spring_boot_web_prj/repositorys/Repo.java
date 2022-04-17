package com.sproject.spring_boot_web_prj.repositorys;

import com.sproject.spring_boot_web_prj.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo {
    public List<Product> getProducts();
    public Product getProductById(Integer id);
}
