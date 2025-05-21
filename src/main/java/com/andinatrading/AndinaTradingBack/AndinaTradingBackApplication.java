package com.andinatrading.AndinaTradingBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.andinatrading.AndinaTradingBack.entity")
@EnableJpaRepositories(basePackages = "com.andinatrading.AndinaTradingBack.repository")
public class AndinaTradingBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(AndinaTradingBackApplication.class, args);
    }
}
