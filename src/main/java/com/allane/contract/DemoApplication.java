package com.allane.contract;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/vehicle/*"))
				.apis(RequestHandlerSelectors.basePackage("com.allane.contract.controller"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		ApiInfo abc = new ApiInfo("Leasing Contract", 
				"Leasing Contracts APIs for Customer",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact("Rushali Dupally", "", "rushali.adakulapalli@gmail.com"),
				"No License Required",
				"License URL: N/A",
				new ArrayList<VendorExtension>());
		return abc;
	}

}
