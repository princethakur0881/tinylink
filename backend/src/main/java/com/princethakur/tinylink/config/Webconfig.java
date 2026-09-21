package com.princethakur.tinylink.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**")
                .allowedOrigins("https://localhost:4200","https://localhost:8082")
                .allowedMethods("GET","POST","DELETE","OPTIONS")
                .allowedHeaders("*");
    }
}
