package com.neurogine.assesment.apidoc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This generates API documentation for the exposed swagger endpoints.
 *
 * @author Chinthana.
 */
@Configuration
@EnableSwagger2
public class ApiDocumentation {
    @Value("${spring.application.name}")
    private String title;

    @Value("${swagger.application.description:Product Management Service}")
    private String description;

    @Value("${swagger.application.version:1.0}")
    private String version;

    @Value("${swagger.application.contact.name:Chinthana}")
    private String name;

    @Value("${swagger.application.contact.url:default}")
    private String url;

    @Value("${swagger.application.contact.email:chinthana.thennakoon@axiatadigitallabs.com}")
    private String email;
    
    /**
     * Configuration for the exposed swagger endpoint.
     *
     * @return Docket.
     */
    @Bean
    public Docket applicationApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.neurogine.assesment.controller"))
                .paths(PathSelectors.ant("/**")).build().apiInfo(apiInfo());        		
    }

    /**
     * Meta information for the API.
     *
     * @return API information object generated.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description).version(version)
                .contact(new Contact(name, url, email)).build();
    }
    
}
