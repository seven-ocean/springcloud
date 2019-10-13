package com.maxchen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ApplicationGateway {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationGateway.class, args);
    }

}