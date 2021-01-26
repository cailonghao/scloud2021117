package com.glassflower.glassflowerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GlassflowerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlassflowerServerApplication.class, args);
    }

}
