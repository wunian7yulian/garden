package com.lynwood.g.base.rock.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Lynwood
 * @Date 2020-01-01
 * @Version 1.0
 */
@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    /**
     * 对Rest 返回 String 统一转换
     */
    @Bean
    public HttpMessageConverters customConverters() {
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        messageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON_UTF8));
        
        FastJsonConfig fastJsonConfig= new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        messageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(messageConverter);
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(2);
    }

}
