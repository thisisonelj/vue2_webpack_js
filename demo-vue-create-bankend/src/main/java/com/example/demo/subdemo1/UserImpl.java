package com.example.demo.subdemo1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserImpl {
    @Autowired
    private UserService userService;
    @Bean
    public void getUserImpl(){
        Log log = LogFactory.getLog(UserImpl.class);
        log.info(userService.getUser());
    }



}
