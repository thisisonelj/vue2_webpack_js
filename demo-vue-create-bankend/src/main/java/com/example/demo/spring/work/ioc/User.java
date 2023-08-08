package com.example.demo.spring.work.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String name;
    @Autowired
    private Order order;
    public User(){
        this.name="liu";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
