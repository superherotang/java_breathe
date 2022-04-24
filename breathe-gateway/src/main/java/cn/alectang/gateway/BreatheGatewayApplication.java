package cn.alectang.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
public class BreatheGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreatheGatewayApplication.class, args);
    }

}



//spring:
//        application:
//        name: breathe-gateway
//        cloud:
//        gateway:
//        routes:
//        - id: user
//        uri: http://localhost:8001
//        predicates:
//        - Path=/breatheUser/**
// filters:
// - StripPrefix=1