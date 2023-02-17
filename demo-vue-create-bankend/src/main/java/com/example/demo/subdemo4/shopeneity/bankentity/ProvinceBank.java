package com.example.demo.subdemo4.shopeneity.bankentity;

import lombok.Data;

@Data
public class ProvinceBank {
    String ProBankId;
    String ProBankName;
    String ProBankType;

    public String getProBankId() {
        return ProBankId;
    }

    public void setProBankId(String proBankId) {
        ProBankId = proBankId;
    }

    public String getProBankName() {
        return ProBankName;
    }

    public void setProBankName(String proBankName) {
        ProBankName = proBankName;
    }

    public String getProBankType() {
        return ProBankType;
    }

    public void setProBankType(String proBankType) {
        ProBankType = proBankType;
    }

    @Override
    public String toString() {
        return "ProvinceBank{" +
                "ProBankId='" + ProBankId + '\'' +
                ", ProBankName='" + ProBankName + '\'' +
                ", ProBankType='" + ProBankType + '\'' +
                '}';
    }
}
