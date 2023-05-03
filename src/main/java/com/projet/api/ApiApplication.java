package com.projet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Permet de lancer le Framework Spring Boot
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
@SpringBootApplication
@EnableSwagger2
public class ApiApplication
{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	public Docket apis(){
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.projet.api")).build();
	}

}
