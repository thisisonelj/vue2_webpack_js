package com.example.demo.subdemo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/demo/person")
@RestController
public class PersonController {
    @PostMapping("/query")
    public String queryPerson(){
        return "liu";
    }
    @GetMapping("/login")
    public String login(){
        return "需要认证";
    }

}
