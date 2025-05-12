package com.example.newCompany;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
@MapperScan("com.example.mapper")
public class NewCompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewCompanyApplication.class, args);
    }
}
