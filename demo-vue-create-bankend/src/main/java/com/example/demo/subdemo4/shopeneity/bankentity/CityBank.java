package com.example.demo.subdemo4.shopeneity.bankentity;

import lombok.Data;

@Data
public class CityBank {
    String CityBankId;
    String CityBankName;
    String CityBankType;

    public String getCityBankId() {
        return CityBankId;
    }

    public void setCityBankId(String cityBankId) {
        CityBankId = cityBankId;
    }

    public String getCityBankName() {
        return CityBankName;
    }

    public void setCityBankName(String cityBankName) {
        CityBankName = cityBankName;
    }

    public String getCityBankType() {
        return CityBankType;
    }

    public void setCityBankType(String cityBankType) {
        CityBankType = cityBankType;
    }

    @Override
    public String toString() {
        return "CityBank{" +
                "CityBankId='" + CityBankId + '\'' +
                ", CityBankName='" + CityBankName + '\'' +
                ", CityBankType='" + CityBankType + '\'' +
                '}';
    }
}
