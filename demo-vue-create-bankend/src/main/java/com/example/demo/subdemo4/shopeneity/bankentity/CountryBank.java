package com.example.demo.subdemo4.shopeneity.bankentity;

import lombok.Data;

@Data
public class CountryBank {
    String CountryBankId;
    String CountryBankName;
    String CountryBankType;

    public String getCountryBankId() {
        return CountryBankId;
    }

    public void setCountryBankId(String countryBankId) {
        CountryBankId = countryBankId;
    }

    public String getCountryBankName() {
        return CountryBankName;
    }

    public void setCountryBankName(String countryBankName) {
        CountryBankName = countryBankName;
    }

    public String getCountryBankType() {
        return CountryBankType;
    }

    public void setCountryBankType(String countryBankType) {
        CountryBankType = countryBankType;
    }

    @Override
    public String toString() {
        return "CountryBank{" +
                "CountryBankId='" + CountryBankId + '\'' +
                ", CountryBankName='" + CountryBankName + '\'' +
                ", CountryBankType='" + CountryBankType + '\'' +
                '}';
    }
}
