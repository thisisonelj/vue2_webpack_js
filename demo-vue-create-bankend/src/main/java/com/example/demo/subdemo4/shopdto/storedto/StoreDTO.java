package com.example.demo.subdemo4.shopdto.storedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class StoreDTO {
    private String id;
    private String storeId;
    private String storeName;
    private GoodDTO goodDTO;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String goodId;
    private String goodName;
    private String aliaId;//用来获取货物信息的id别名
    private String parentId;//用来存放树结构的父节点
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GoodDTO getGoodDTO() {
        return goodDTO;
    }

    public void setGoodDTO(GoodDTO goodDTO) {
        this.goodDTO = goodDTO;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getAliaId() {
        return aliaId;
    }

    public void setAliaId(String aliaId) {
        this.aliaId = aliaId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "id='" + id + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storeName='" + storeName + '\'' +
                ", goodDTO=" + goodDTO +
                ", createTime=" + createTime +
                ", goodId='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                ", aliaId='" + aliaId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
