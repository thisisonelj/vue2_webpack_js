package com.example.demo.spring.work;

import com.example.demo.spring.work.ioc.Order;
import com.example.demo.spring.work.ioc.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringDemoApplication {
    public static Logger printLogger(){
       Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);
       return logger;
    }
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDemoApplication.class);
        User user = context.getBean(User.class);
        Order order = context.getBean(Order.class);
        printLogger().info(user.toString());
        printLogger().info(order.toString());
    }




}
