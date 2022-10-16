package com.example.phamacy_linechatbot_backend;

import com.google.auth.oauth2.GoogleCredentials;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Objects;

@SpringBootApplication
public class PhamacyLineChatBotBackendApplication {

    public PhamacyLineChatBotBackendApplication() throws IOException {
    }

    public static void main(String[] args) throws IOException {

        SpringApplication.run(PhamacyLineChatBotBackendApplication.class, args);

    }



    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081",
                                "http://172.20.10.2:8081/",
                                "https://phamacy-linebot-project.web.app",
                        "http://localhost:8081",
                                "http://52.230.104.188:8001/").
                        allowedMethods("PUT", "DELETE",
                                "GET", "POST")

                        .exposedHeaders("x-total-count");
            }
        };


    }
}
