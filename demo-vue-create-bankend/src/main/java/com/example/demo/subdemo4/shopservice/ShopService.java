package com.example.demo.subdemo4.shopservice;

import com.example.demo.subdemo4.shopdto.ShopDBDTO;
import com.example.demo.subdemo4.shopdto.ShopDTO;
import com.example.demo.subdemo4.shopeneity.ShopUser;

import java.util.List;

public interface ShopService {
    int shopAddInfo(ShopDTO shopDTO);//添加用户购物信息

    List<ShopDBDTO> shopQueryInfo(ShopUser shopUser);//条件查询

    List<ShopDBDTO> selectShopByUserId(ShopUser shopUser);//添加过滤

    int shopRemove(ShopDBDTO shopDBDTO);//条件删除
}
