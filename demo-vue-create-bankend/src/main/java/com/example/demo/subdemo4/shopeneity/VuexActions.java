package com.example.demo.subdemo4.shopeneity;

import lombok.Data;

@Data
public class VuexActions {
    private int size;
    private String name;
    private int age;
    private int index;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "VuexActions{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", index=" + index +
                '}';
    }
}
