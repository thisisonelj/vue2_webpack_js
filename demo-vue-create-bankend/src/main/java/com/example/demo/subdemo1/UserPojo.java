package com.example.demo.subdemo1;

import org.springframework.stereotype.Component;

@Component
public class UserPojo {
    private String name;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
