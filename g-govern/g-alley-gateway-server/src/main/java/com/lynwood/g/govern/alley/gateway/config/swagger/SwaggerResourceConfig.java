package com.lynwood.g.govern.alley.gateway.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Spring Boot单体架构集成swagger时，是通过包路径进行业务分组，然后在前端进行不同模块的展示，而在微服务架构下，单个服务类似于原来业务组；
 * springfox-swagger提供的分组接口是swagger-resource，返回的是分组接口名称、地址等信息；
 * 在Spring Cloud微服务架构下，需要swagger-resource重写接口，由网关的注册中心动态发现所有的微服务文档
 */
@Primary
@Configuration
public class SwaggerResourceConfig implements SwaggerResourcesProvider {
    @Autowired
    private RouteLocator routeLocator;
    @Autowired
    private GatewayProperties gatewayProperties;

    //接口地址
    private static final String API_URI = "/v2/api-docs";

    @Override
    public List<SwaggerResource> get() {

        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        // 取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        // 结合配置的route-路径(Path)，和route过滤，只获取在枚举中说明的route节点
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                        .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
                                predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                        .replace("/**", API_URI)))
                        )
                );
        return resources;
    }
    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("3.0");
        return swaggerResource;
    }
}