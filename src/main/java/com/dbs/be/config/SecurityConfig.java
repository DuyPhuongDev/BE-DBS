package com.dbs.be.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig<CorsRegistry> implements WebMvcConfigurer {
    private static final String[] PERMITTED_API_ROUTES = {
            "/", "/api/v1/**", "/swagger-ui/**", "/v3/api-docs/**", "/trigger/**"
    };

    // TODO: Restrict cors when deploy to the production
    private static final String CORS_PATH_PATTERNS = "/**";
    private static final String[] CORS_ALLOWED_ORIGINS = {"*"};
    private static final String[] CORS_ALLOWED_HEADERS = {"*"};
    private static final String[] CORS_EXPOSED_HEADERS = {"*"};
    private static final String[] CORS_ALLOWED_METHODS = {
            "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS"
    };

//    @Override
//    public void addCorsMappings(@NonNull CorsRegistry registry) {
//        registry
//                .addMapping(CORS_PATH_PATTERNS)
//                .allowedOrigins(CORS_ALLOWED_ORIGINS)
//                .allowedHeaders(CORS_ALLOWED_HEADERS)
//                .exposedHeaders(CORS_EXPOSED_HEADERS)
//                .allowedMethods(CORS_ALLOWED_METHODS);
//    }
}