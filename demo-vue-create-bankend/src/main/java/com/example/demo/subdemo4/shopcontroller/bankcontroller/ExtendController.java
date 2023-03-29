package com.example.demo.subdemo4.shopcontroller.bankcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/demo/extend")
@RestController

@CrossOrigin
public class ExtendController {

    @PostMapping("/debounce")
    public String debounceInfo(){
        return "每五秒显示一次信息";
    }
}
