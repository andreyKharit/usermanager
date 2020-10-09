package com.ankhar.usermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ankhar.usermanager.entities")
@EnableJpaRepositories(basePackages = "com.ankhar.usermanager.repositories")
public class UsermanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanagerApplication.class, args);
    }

}
