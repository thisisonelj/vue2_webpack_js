package com.example.demo.spring.work.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Order {
    private Integer id;
    @Autowired
    private Price price;
    public Order(){
        this.id=24;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
