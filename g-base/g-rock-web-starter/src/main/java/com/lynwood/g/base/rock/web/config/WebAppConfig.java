package com.lynwood.g.base.rock.web.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author Lynwood
 * @Date 2023/5/24
 * @Version 1.0
 */
@EnableAsync
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
public class WebAppConfig {
}
