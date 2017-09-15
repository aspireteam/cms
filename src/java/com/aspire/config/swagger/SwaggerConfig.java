package com.aspire.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
// 启用swagger
@EnableSwagger2
public class SwaggerConfig {
	  @Bean
	    public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(this.apiInfo())
	                // 设置组名
	                .groupName("cms管理")
	                .useDefaultResponseMessages(false)
	                .enableUrlTemplating(false)
	                .select()
	                // 设置接口controller位置
	                .apis(RequestHandlerSelectors.basePackage("com.aspire.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("CMS内容管理系统 API")
	                .description("CMS项目API")
	                .termsOfServiceUrl("127.0.0.1:8989/")
	                // 版本
	                .version("0.0.1")
	                .build();
	    }
}
