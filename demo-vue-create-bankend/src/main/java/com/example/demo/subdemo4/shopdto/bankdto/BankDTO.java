package com.example.demo.subdemo4.shopdto.bankdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BankDTO {
   String bankId;
   String bankName;
   String bankType;
   String parentCode;
   Boolean leafCode;
   String parentName;
   @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
   Date createTime;
   BankPagation bankPagation;//分页对象
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Boolean getLeafCode() {
        return leafCode;
    }

    public void setLeafCode(Boolean leafCode) {
        this.leafCode = leafCode;
    }

    public BankPagation getBankPagation() {
        return bankPagation;
    }

    public void setBankPagation(BankPagation bankPagation) {
        this.bankPagation = bankPagation;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "bankId='" + bankId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankType='" + bankType + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", leafCode=" + leafCode +
                ", parentName='" + parentName + '\'' +
                ", createTime=" + createTime +
                ", bankPagation=" + bankPagation +
                '}';
    }
}
