package com.sproject.spring_boot_web_prj.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "coast")
    private double coast;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "carts",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersList;

    public Product( String title, double coast) {
        this.title = title;
        this.coast = coast;
    }
    public Product() {
    }

}
