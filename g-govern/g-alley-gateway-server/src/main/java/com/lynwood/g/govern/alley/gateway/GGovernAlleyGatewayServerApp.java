package com.lynwood.g.govern.alley.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Lynwood
 * @Date 2023/5/22
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GGovernAlleyGatewayServerApp {
    public static void main(String[] args) {
        SpringApplication.run(GGovernAlleyGatewayServerApp.class, args);
    }
}
