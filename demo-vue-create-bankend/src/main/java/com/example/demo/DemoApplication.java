package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.subdemo2"})
@EnableTransactionManagement(proxyTargetClass = true)
public class DemoApplication {
//    @Bean
//    WebMvcConfigurer createWebMvcConfigurer() {
//        return new WebMvcConfigurer() {
//
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8080")
//                        .allowedMethods("GET", "POST")
//                        .maxAge(3600);
//                // 可以继续添加其他URL规则:
//                // registry.addMapping("/rest/v2/**")...
//
//            }
//        };
//    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
