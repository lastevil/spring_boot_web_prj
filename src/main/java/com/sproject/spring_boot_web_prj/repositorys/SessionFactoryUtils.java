package com.sproject.spring_boot_web_prj.repositorys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class SessionFactoryUtils {
    private SessionFactory factory;

    @PostConstruct
    public void init() {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
    }
    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shotdown(){
        if(factory != null){
            factory.close();
        }
    }
}
