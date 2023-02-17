package com.example.demo.subdemo4.shopdto.bankdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SchemeBankDTO {
    String schemeId;
    String schemeName;
    String bankName;
    String bankType;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createTime;
    String parentCode;
    String parentName;

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "SchemeBankDTO{" +
                "schemeId='" + schemeId + '\'' +
                ", schemeName='" + schemeName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankType='" + bankType + '\'' +
                ", createTime=" + createTime +
                ", parentCode='" + parentCode + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
