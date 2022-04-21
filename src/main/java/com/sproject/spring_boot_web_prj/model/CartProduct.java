package com.sproject.spring_boot_web_prj.model;

import lombok.Data;

@Data
public class CartProduct {
    private Integer id;
    private String title;
    private Double coast;
    private Integer count;

    public CartProduct(Integer id, String title, Double coast, Integer count) {
        this.id = id;
        this.title = title;
        this.coast = coast;
        this.count = count;
    }
}
