package com.sl.ms.inventorymanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableCaching  
public class InventoryManagementApplication {
	private final static  Logger logger = LoggerFactory.getLogger(InventoryManagementApplication.class);
	public static void main(String[] args) {
		logger.info("Starting InventoryManagementApplication ");
		SpringApplication.run(InventoryManagementApplication.class, args);
	}
		
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/api/*"))
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.sl.ms.inventorymanagement"))
				.build()
				.apiInfo(apiInfo());
		
		
	}
	
	private ApiInfo apiInfo()
	
	{
		return new ApiInfoBuilder()
				.title("sample inventorymanagement")
				.description("sample inventorymanagement APIs")
				.license("License")
				.licenseUrl("License of API")
				.termsOfServiceUrl("API TOS")
				.version("1.0")
				.contact(new springfox.documentation.service.Contact("Prabhu","","prabhu.palanivel@gmail.com"))
				.build();
		
	}

}
