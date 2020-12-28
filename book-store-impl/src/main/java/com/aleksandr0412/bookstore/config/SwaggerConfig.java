package com.aleksandr0412.bookstore.config;

import com.aleksandr0412.bookstore.config.properties.SwaggerProperties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@Profile("swagger")
public class SwaggerConfig {

    private final SwaggerProperties swaggerProperties;

    private final BuildProperties buildProperties;

    public SwaggerConfig(SwaggerProperties swaggerProperties, BuildProperties buildProperties) {
        this.swaggerProperties = swaggerProperties;
        this.buildProperties = buildProperties;
    }

    @Bean
    public Docket apiOrder() {
        return buildDocket("/api");
    }

    @Bean
    public Docket apiActuator() {
        return buildDocket("/actuator");
    }

    protected Docket buildDocket(final String serviceUrl) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(String.format("%s/", serviceUrl))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex(String.format(".*%s.*", serviceUrl)))
                .build()
                .apiInfo(metadata());
    }

    protected ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(buildProperties.getVersion())
                .contact(new Contact(
                        swaggerProperties.getContact().getName(),
                        swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getMail()
                ))
                .build();
    }

}
