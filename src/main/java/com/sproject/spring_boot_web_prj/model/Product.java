package com.sproject.spring_boot_web_prj.model;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String title;
    private double coast;


    public Product(Integer id, String title, double coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

}
