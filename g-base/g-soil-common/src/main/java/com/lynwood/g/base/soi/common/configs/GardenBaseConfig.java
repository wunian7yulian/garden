package com.lynwood.g.base.soi.common.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 公共基本配置
 */
@Data
@RefreshScope
@Configuration
public class GardenBaseConfig {

    /**
     *域名配置
     */
    @Value("${lynwood.garden.domain}")
    private String domain;

}
