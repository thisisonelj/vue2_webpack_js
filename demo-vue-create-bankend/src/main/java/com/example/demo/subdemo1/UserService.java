package com.example.demo.subdemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("user")
public class UserService {
    @Autowired
    private UserPojo userPojo;

    public UserPojo getUser() {
        this.userPojo.setId(100);
        this.userPojo.setName("liu");
        return this.userPojo;
    }
}
