package com.fish.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FishServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishServerApplication.class, args);
    }

}
