package com.faculty.configuration;
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
	public class CollegeSocialNetworkConfig {
		@Bean 
		public Docket evsModule() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.faculty"))
					
					.build()
					.apiInfo(getApiInfo());
		}
		private ApiInfo getApiInfo() {
			ApiInfo apiInfo = new ApiInfo("College Social Network API Documentation", 
					"This is College Social Network  info", 
					"1.0", 
					"public terms of services",
					new Contact("College Social Network Team", "http://csnteam.com", "csnteam@gmail.com"),
					"GPL",
					"http://gpl.info"
					);
			return apiInfo;
		}
	}


