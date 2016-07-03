package com.torysoft.bugsoffice.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket petApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
		        .select()
		          .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
		          .paths(PathSelectors.any())
		          .build();
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfo("Bugsoffice", "Bug and Test Case management system", "1.0", "http://www.bugsoffice.com", "david.sun@torysoft.com", "", "");
	}
}
