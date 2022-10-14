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

//        ClassLoader classLoader = PhamacyLineChatBotBackendApplication.class.getClassLoader();
//        File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
//        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

//        FileInputStream serviceAccount =
//                new FileInputStream("src/main/resources/ServiceAccountKey.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://phamacy-linebot-project-default-rtdb.asia-southeast1.firebasedatabase.app")
//                .build();
//
//        if(FirebaseApp.getApps().isEmpty()) { FirebaseApp.initializeApp(options); } else { FirebaseApp.getInstance() ;}

        SpringApplication.run(PhamacyLineChatBotBackendApplication.class, args);

    }



    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081","http://172.20.10.2:8081/","https://phamacy-linebot-project.web.app").
                        allowedMethods("PUT", "DELETE",
                                "GET", "POST")

                        .exposedHeaders("x-total-count");
            }
        };


    }
}
