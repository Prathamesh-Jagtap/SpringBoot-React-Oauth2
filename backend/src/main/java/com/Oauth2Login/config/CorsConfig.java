package com.Oauth2Login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Allow requests from your frontend (React) origin
        corsConfiguration.addAllowedOrigin("http://localhost:5173");

        // Allow sending credentials like cookies or authentication tokens
        corsConfiguration.setAllowCredentials(true);

        // Allow common HTTP methods
        corsConfiguration.addAllowedMethod("*");

        // Allow all headers in requests
        corsConfiguration.addAllowedHeader("*");

        // Expose any headers that you want to be accessible on the frontend
        corsConfiguration.addExposedHeader("Authorization");

        // Set up the URL mapping for CORS configuration
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }
}
