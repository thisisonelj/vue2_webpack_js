package com.example.demo.subdemo4.shopMapper;

import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopdto.bankdto.SchemeBankDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BankSchemeMapper {
    @InsertProvider(type = BankSchemeMapper.SchemeBankAdd.class, method = "schemeBankAdd")
    Integer schemeBankAdd(SchemeBankDTO schemeBankDTO);
    class SchemeBankAdd {
        public String schemeBankAdd(SchemeBankDTO schemeBankDTO) {
            SQL sql = new SQL();
            sql.INSERT_INTO("scheme_tb");
            sql.VALUES("schemeId", "#{schemeId}");
            sql.VALUES("schemeName", "#{schemeName}");
            sql.VALUES("bankName", "#{bankName}");
            sql.VALUES("bankType", "#{bankType}");
            sql.VALUES("createTime", "#{createTime}");
            sql.VALUES("parentCode", "#{parentCode}");
            sql.VALUES("parentName", "#{parentName}");
            return sql.toString();

        }
    }

    @SelectProvider(type =  BankSchemeMapper.SchemeBankQueryAll.class, method = "schemeBankQueryAll")
    List<SchemeBankDTO> schemeBankQueryAll(SchemeBankDTO schemeBankDTO);
    class SchemeBankQueryAll {
        public String schemeBankQueryAll(SchemeBankDTO schemeBankDTO) {
            SQL sql = new SQL();
            sql.SELECT("schemeId,schemeName,bankName,bankType,parentCode,parentName,createTime");
            sql.FROM("scheme_tb");
            return sql.toString();
        }
    }

    @SelectProvider(type =  BankSchemeMapper.SchemeBankQueryById.class, method = "schemeBankQueryById")
    SchemeBankDTO schemeBankQueryById(SchemeBankDTO schemeBankDTO);
    class SchemeBankQueryById {
        public String schemeBankQueryById(SchemeBankDTO schemeBankDTO) {
            SQL sql = new SQL();
            sql.SELECT("schemeId,schemeName,bankName,bankType,parentCode,parentName,createTime");
            sql.FROM("scheme_tb");
            sql.WHERE("schemeId=#{schemeId}");
            return sql.toString();
        }
    }

    @UpdateProvider(type = BankSchemeMapper.SchemeBankUpdateById.class, method = "schemeBankUpdateById")
    Integer schemeBankUpdateById(SchemeBankDTO schemeBankDTO);
    class SchemeBankUpdateById {
        public String schemeBankUpdateById(SchemeBankDTO schemeBankDTO) {
            SQL sql = new SQL();
            sql.UPDATE("scheme_tb");
            if(schemeBankDTO.getSchemeId()!=null){
                sql.SET("schemeId=#{schemeId}");
            }
            if(schemeBankDTO.getSchemeName()!=null){
                sql.SET("schemeName = #{schemeName}");
            }
            if(schemeBankDTO.getBankName()!=null){
                sql.SET("bankName = #{bankName}");
            }
            if(schemeBankDTO.getBankType()!=null){
                sql.SET("bankType = #{bankType}");
            }
            if(schemeBankDTO.getParentCode()!=null){
                sql.SET("parentCode = #{parentCode}");
            }
            if(schemeBankDTO.getParentName()!=null){
                sql.SET("parentName = #{parentName}");
            }
            if(schemeBankDTO.getCreateTime()!=null){
                sql.SET("createTime = #{createTime}");
            }
            sql.WHERE("schemeId = #{schemeId}");
            return sql.toString();

        }
    }

    @DeleteProvider(type = BankSchemeMapper.SchemeBankDeleteById.class,method = "schemeBankDeleteById")
    Integer schemeBankDeleteById(SchemeBankDTO schemeBankDTO);
    class SchemeBankDeleteById{
        public String schemeBankDeleteById(SchemeBankDTO schemeBankDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("scheme_tb");
            sql.WHERE("schemeId = #{schemeId}");
            return  sql.toString();
        }
    }

    @SelectProvider(type =  BankSchemeMapper.SelectByScheme.class, method = "selectByScheme")
    List<BankDTO> selectByScheme(SchemeBankDTO schemeBankDTO);
    class SelectByScheme{
        public String selectByScheme(SchemeBankDTO schemeBankDTO) {
            SQL sql=new SQL();
            sql.SELECT("bankId,bankName,bankType,parentCode,parentName,leafCode,createTime");
            sql.FROM("bank_tb");
            if(!schemeBankDTO.getBankName().equals("")){
            sql.WHERE("bankName=#{bankName}");
            }
            sql.WHERE("bankType=#{bankType}");
            if(schemeBankDTO.getCreateTime()!=null){
            sql.WHERE("createTime=#{createTime}");
            }
            return sql.toString();
        }
    }
}
