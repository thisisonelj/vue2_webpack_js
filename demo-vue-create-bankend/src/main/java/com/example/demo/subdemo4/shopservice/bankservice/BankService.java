package com.example.demo.subdemo4.shopservice.bankservice;

import com.example.demo.subdemo4.shopdto.ShopDBDTO;
import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopeneity.ShopUser;

import java.util.List;

public interface BankService {
    int bankAddInfo(BankDTO bankDTO);//添加银行信息


    List<BankDTO> bankQueryAllInfo(BankDTO bankDTO);//查询所有

     int bankDeleteInfo(List<BankDTO> bankDTOList);//删除银行信息
    List<BankDTO> bankQueryPagetion(BankDTO bankDTO);//分页查询数据
    List<BankDTO> bankQuerySingle(BankDTO bankDTO);//按银行代码查询
    int bankUpdateInfo(BankDTO bankDTO);//修改银行数据


}
