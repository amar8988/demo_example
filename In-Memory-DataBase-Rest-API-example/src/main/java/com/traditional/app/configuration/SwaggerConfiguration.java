package com.traditional.app.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;

/**
 * Configuration class which enables Swagger
 *
 * @author Debu
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {



	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.traditional.app.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Spring Boot Reactive - WebFlux API Gateway",
				"WebFlux Reactive Rest API for FICO Using Spring Boot", "API", "Terms of service",
				new Contact("Pramati", "www.demoapi.com", "myeaddress@company.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

}
