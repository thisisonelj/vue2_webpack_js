package com.example.demo.subdemo4.websocket;

import lombok.Data;

@Data
public class SocketParams {
    private String id;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SocketParams{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
