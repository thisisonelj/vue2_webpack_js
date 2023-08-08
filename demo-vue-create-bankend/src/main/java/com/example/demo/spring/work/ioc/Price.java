package com.example.demo.spring.work.ioc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Price {
    private Double price;
    Price(){
      this.price=20.00;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }
}
