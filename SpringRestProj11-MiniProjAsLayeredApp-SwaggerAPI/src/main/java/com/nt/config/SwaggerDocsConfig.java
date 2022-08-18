package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nt.controller"))
				.paths(PathSelectors.regex("/actor.*"))
				.build()
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {		
		Contact contact = new Contact("raja","http://www.hcl.com/tourist","natarazjavaarena@gmail.com");
		return new ApiInfo("Actor Api",
				"Gives Actor Details Info",
				"3.4 RELEASE",
				"http://www.hcl.com/license",
				contact,
				"GNU PUBLIC",
				"http://apache.org/license/gnu",
				Collections.emptyList());
	}
}
