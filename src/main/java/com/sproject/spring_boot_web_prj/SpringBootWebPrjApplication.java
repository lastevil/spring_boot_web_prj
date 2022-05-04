package com.sproject.spring_boot_web_prj;

import com.sproject.spring_boot_web_prj.repositorys.SessionFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebPrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppConf.class, args);
	}

}
