package com.lynwood.g.base.soi.common.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 公共基本配置
 */
@Data
@Configuration
public class GardenBaseConfig {

    /**
     *域名配置
     */
    @Value("${lynwood.garden.domain:http://localhost:8080}")
    private String domain;

}
