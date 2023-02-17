package com.example.demo.subdemo2;

import lombok.Data;

@Data
public class PersonPojo {
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
