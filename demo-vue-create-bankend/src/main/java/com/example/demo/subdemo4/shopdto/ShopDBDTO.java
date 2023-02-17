package com.example.demo.subdemo4.shopdto;

import lombok.Data;

import java.util.Date;

@Data
public class ShopDBDTO {
    private Integer userId;
    private String name;
    private Integer age;
    private Boolean sex;
    private Date shopDate;
    private Integer storeId;
    private String storeName;
    private Integer goodId;
    private String goodName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getShopDate() {
        return shopDate;
    }

    public void setShopDate(Date shopDate) {
        this.shopDate = shopDate;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

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
        return "ShopDBDTO{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", shopDate=" + shopDate +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}
