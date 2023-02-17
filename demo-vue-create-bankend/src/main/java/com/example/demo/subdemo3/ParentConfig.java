package com.example.demo.subdemo3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.example.demo.subdemo3"})
public class ParentConfig {
    @Bean
    public void parentHandle(){
        Log log = LogFactory.getLog(ParentConfig.class);
        log.info("这是父类配置");
    }
}
