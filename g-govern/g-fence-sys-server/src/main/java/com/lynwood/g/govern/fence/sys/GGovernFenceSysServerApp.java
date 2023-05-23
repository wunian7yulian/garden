package com.lynwood.g.govern.fence.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Author Lynwood
 * @Date 2023/5/22
 * @Version 1.0
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class GGovernFenceSysServerApp {
    public static void main(String[] args) {
        SpringApplication.run(GGovernFenceSysServerApp.class, args);
    }
}
