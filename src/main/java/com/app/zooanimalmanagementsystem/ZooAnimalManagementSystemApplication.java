package com.app.zooanimalmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ZooAnimalManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooAnimalManagementSystemApplication.class, args);
    }

}
