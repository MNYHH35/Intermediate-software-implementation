package com.example.movieplanet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // 配置允许跨域访问的路径
                .allowedOrigins("http://localhost:3000")  // 允许跨域访问的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的请求方法
                .allowCredentials(true);  // 是否允许发送 cookie
    }
}
