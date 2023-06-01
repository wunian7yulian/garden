package com.lynwood.g.base.rock.web.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author： Lynwood
 */
@Configuration
@EnableFeignClients(basePackages = "com.lynwood.g")
public class FeignConfig {
    @Value("${spring.application.name}")
    private String applicationName;
    /**
     * 让DispatcherServlet向子线程传递RequestContext
     *
     * @param servlet servlet
     * @return 注册bean
     */
    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet servlet) {
        servlet.setThreadContextInheritable(true);
        return new ServletRegistrationBean<>(servlet, "/**");
    }

    /**
     * 覆写拦截器，在feign发送请求前取出原来的header并转发
     *
     * @return 拦截器
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return (template) -> {
            ServletRequestAttributes
                    attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            if(attributes!=null) {// 用户请求 转发 header 其实转不转发都行
                HttpServletRequest request = attributes.getRequest();
                //获取请求头
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String values = request.getHeader(name);
                        //将请求头保存到模板中
                        if (!name.equalsIgnoreCase("serviceName")) {
                            template.header(name, values);
                        }
                    }
                }
            }
            // 塞入当前 服务名称 做限流 (针对来源 )
            template.header("serviceName", applicationName);
        };
    }
}