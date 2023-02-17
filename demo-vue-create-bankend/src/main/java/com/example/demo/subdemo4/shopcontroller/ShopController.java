package com.example.demo.subdemo4.shopcontroller;

import com.example.demo.subdemo4.shopdto.ShopDBDTO;
import com.example.demo.subdemo4.shopdto.ShopDTO;
import com.example.demo.subdemo4.shopeneity.ShopUser;
import com.example.demo.subdemo4.shopserviceimpl.ShopServiceImpl;
import com.example.demo.subdemo4.shoputils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/demo/shop")
@RestController
@CrossOrigin
public class ShopController {
    @Autowired
    private ShopServiceImpl shopServiceImpl;

    @PostMapping("/add")
    public ResultUtil<Object> shopAdd(@RequestBody ShopDTO shopDTO) {
        return shopServiceImpl.shopAddInfo(shopDTO)== 3
                ? ResultUtil.resultSuccessful(3)
                : ResultUtil.resultFailure(500, "数据添加错误");
    }
    @PostMapping("/query")
    public ResultUtil<Object> shopQuery(@RequestBody ShopUser shopUser){
        return  ResultUtil.resultSuccessful(shopServiceImpl.shopQueryInfo(shopUser));
    }
    @PostMapping("/valid")
    public ResultUtil<Object> shopValid(@RequestBody ShopUser shopUser){
        return  ResultUtil.resultSuccessful(shopServiceImpl.selectShopByUserId(shopUser));
    }
    @PostMapping("/delete")
    public ResultUtil<Object> shopRemove(@RequestBody ShopDBDTO shopDBDTO){
        return  ResultUtil.resultSuccessful(shopServiceImpl.shopRemove(shopDBDTO));
    }
}
