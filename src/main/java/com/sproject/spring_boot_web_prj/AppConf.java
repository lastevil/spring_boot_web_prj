package com.sproject.spring_boot_web_prj;

import com.sproject.spring_boot_web_prj.repositorys.SessionFactoryUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sproject.spring_boot_web_prj")
public class AppConf {

    @Bean
    public SessionFactoryUtils session(){
        return new SessionFactoryUtils();
    }
}
