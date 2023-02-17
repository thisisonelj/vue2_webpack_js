package com.example.demo.subdemo4.shopeneity;

import lombok.Data;

/**
 商店
 */
@Data
public class ShopStore {
    private Integer storeId;
    private  String storeName;

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

    @Override
    public String toString() {
        return "ShopStore{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
