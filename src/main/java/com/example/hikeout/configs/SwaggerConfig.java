package com.example.hikeout.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration file for Swagger.
 *
 * Go to localhost:8080/swagger-ui/index.html to see API's
 * */
@OpenAPIDefinition
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Spring Doc").version("1.0.0"));
    }
}