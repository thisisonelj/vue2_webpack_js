package com.example.demo.subdemo4.shopeneity;

import lombok.Data;

/**
 商品
 */
@Data
public class ShopGood {
    private Integer goodId;
    private String goodName;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Override
    public String toString() {
        return "ShopGood{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}
