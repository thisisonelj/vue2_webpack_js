package com.example.demo.subdemo4.shopdto;

import com.example.demo.subdemo4.shopeneity.ShopGood;
import com.example.demo.subdemo4.shopeneity.ShopStore;
import com.example.demo.subdemo4.shopeneity.ShopUser;
import lombok.Data;

import java.util.Map;

/**
 接受前端数据
 */
@Data
public class ShopDTO {
    private ShopUser shopUser;//购物用户
    private ShopGood shopGood;//购物商品
    private ShopStore shopStore;//购物商店
    private Map<String,Object> extendParams;//其他数据参数

    public ShopUser getShopUser() {
        return shopUser;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }

    public ShopGood getShopGood() {
        return shopGood;
    }

    public void setShopGood(ShopGood shopGood) {
        this.shopGood = shopGood;
    }

    public ShopStore getShopStore() {
        return shopStore;
    }

    public void setShopStore(ShopStore shopStore) {
        this.shopStore = shopStore;
    }

    public Map<String, Object> getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(Map<String, Object> extendParams) {
        this.extendParams = extendParams;
    }

    @Override
    public String toString() {
        return "shopDTO{" +
                "shopUser=" + shopUser +
                ", shopGood=" + shopGood +
                ", shopStore=" + shopStore +
                ", extendParams=" + extendParams +
                '}';
    }
}
