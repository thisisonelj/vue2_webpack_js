package com.example.demo.subdemo4.shopservice.bankservice;

import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopdto.bankdto.SchemeBankDTO;

import java.util.List;

public interface BankSchemeService {
    String bankSchemeAdd(SchemeBankDTO schemeBankDTO);//添加查询方案信息
    List<SchemeBankDTO> schemeQueryAll(SchemeBankDTO schemeBankDTO);//查询所有方案
    SchemeBankDTO schemeQueryById(SchemeBankDTO schemeBankDTO);//通过方案id来查询信息
    String bankSchememUpdate(SchemeBankDTO schemeBankDTO);//通过方案id来修改信息
    String bankSchememDelete(List<SchemeBankDTO> schemeBankDTOList);//通过方案id来删除信息
    List<BankDTO> selectScheme(SchemeBankDTO schemeBankDTO);//通过方案来查询信息
}
