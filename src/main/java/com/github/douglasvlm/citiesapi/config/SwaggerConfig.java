package com.github.douglasvlm.citiesapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.github.douglasvlm.citiesapi.controller";
    private static final String API_TITLE = "Cities API";
    private static final String API_DESCRIPTION = "REST API";
    private static final String CONTACT_NAME = "Douglas Martin";
    private static final String CONTACT_GITHUB = "https://gtihub.com/douglasvlm";
    private static final String CONTACT_EMAIL = "#";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("1.0.0")
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
}