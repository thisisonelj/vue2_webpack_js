package com.example.demo.subdemo4.shopserviceimpl;

import com.example.demo.subdemo4.shopMapper.ShopMapper;
import com.example.demo.subdemo4.shopdto.ShopDTO;
import com.example.demo.subdemo4.shopeneity.ShopUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShopServiceImplTest {

    @Autowired
    private ShopMapper shopMapper;
    @Test
    public void shopAddInfo() {
        ShopUser shopUser=new ShopUser();
        shopUser.setName("liu");
        shopMapper.shopAddInfo(shopUser);

    }
}