package com.example.notomatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NotomaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotomaticApplication.class, args);
    }

    @RestController
    @RequestMapping("/api/test")
    public class TestController {

        @GetMapping
        public String getTestData() {
            return "Hello from the backend!";
        }
    }

    @Configuration
    @EnableWebMvc
    public class CorsConfig implements WebMvcConfigurer {

        @Override
	 public void addCorsMappings(CorsRegistry registry) {
        // Configuration pour toutes les routes sous /api/**
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .allowedHeaders("*");

        // Configuration spécifique pour la route de connexion
        registry.addMapping("/api/users/connexion")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("POST")
                .allowCredentials(true)
                .allowedHeaders("*");

        // Configuration spécifique pour la route d'inscription
        registry.addMapping("/api/users/inscription")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("POST")
                .allowCredentials(true)
                .allowedHeaders("*");
    }
}
}