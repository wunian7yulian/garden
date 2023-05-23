package com.lynwood.g.base.rock.web.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: swagger配置文件
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {
    @Value("${spring.profiles.active:dev}")
    private String env;
    @Value("${spring.application.name:default}")
    private String serviceName;
    @Value("${spring.application.name:default}")
    private String serviceNameForGateway;

    @Bean
    public Docket createDocket(ServletContext servletContext)
    {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .forCodeGeneration(true)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.dyd.rdcenter"))
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title(serviceName + "接口文档")
                        .version("1.0")
                        .contact(new Contact("Lynwood","https://github.com/wunian7yulian","wunian_@hotmail.com"))
                        .license("Lynwood-R&D-Center")
                        .build())
                // 如果为生产环境，则不创建swagger
                .enable(!"prod".equals(env))
                .globalOperationParameters(globalParam());

        // 在knife4j前端页面的地址路径中添加gateway网关的项目名，解决在调试接口、发送请求出现404的问题
        docket.pathProvider(new RelativePathProvider(servletContext)
        {
            @Override
            public String getApplicationBasePath()
            {
                return "/" + serviceNameForGateway + super.getApplicationBasePath();
            }
        });

        return docket;
    }

    /**
     * 设置全局的必要请求参数
     *
     * @return
     */
    private List<Parameter> globalParam() {
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder
                .parameterType("header")
                .name("Authorization")
                .description("header中Authorization字段用于认证,并以Bearer 开头")
                .modelRef(new ModelRef("String"))
                //非必需 这里是全局配置 在登陆/token刷新/注册/找回密码时是不用
                .required(false).build();
        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());
        return aParameters;
    }

}