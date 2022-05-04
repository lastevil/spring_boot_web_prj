package com.sproject.spring_boot_web_prj.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private Integer password;

    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "carts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    public User(String login, String password) {
        this.login = login;
        this.password = password.hashCode();
    }

    public User() {

    }
}
