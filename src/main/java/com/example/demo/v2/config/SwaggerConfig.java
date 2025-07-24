package com.example.demo.v2.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi v1() {
        return GroupedOpenApi.builder()
                .group("V1 API")
                .packagesToScan("com.example.demo.v1.controller")
                .build();
    }

    @Bean
    public GroupedOpenApi v2() {
        return GroupedOpenApi.builder()
                .group("V2 API")
                .packagesToScan("com.example.demo.v2.controller")
                .build();
    }


}
