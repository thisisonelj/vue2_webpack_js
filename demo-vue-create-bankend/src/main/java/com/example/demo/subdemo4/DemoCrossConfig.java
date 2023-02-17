package com.example.demo.subdemo4;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class DemoCrossConfig implements WebMvcConfigurer {
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/rest/demo/").allowedOrigins("http://localhost:8080").allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
    }
}
