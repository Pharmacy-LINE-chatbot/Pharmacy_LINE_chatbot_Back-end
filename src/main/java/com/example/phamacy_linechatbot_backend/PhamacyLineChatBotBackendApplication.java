package com.example.phamacy_linechatbot_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class PhamacyLineChatBotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhamacyLineChatBotBackendApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081").
                        allowedMethods("PUT", "DELETE",
                                "GET", "POST")

                        .exposedHeaders("x-total-count");
            }
        };


    }
}
