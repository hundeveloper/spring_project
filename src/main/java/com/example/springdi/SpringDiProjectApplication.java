package com.example.springdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.book")
@EntityScan(basePackages = "com.example.book.entity")
@EnableJpaRepositories(basePackages = "com.example.book.repository")
public class SpringDiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDiProjectApplication.class, args);
    }

}
