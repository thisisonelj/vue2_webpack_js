package com.example.demo.subdemo4.shopMapper;

import com.example.demo.subdemo4.shopdto.ShopDBDTO;
import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopeneity.ShopUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BankMapper {
    @InsertProvider(type = BankMapper.BankCountryAddInfo.class, method = "bankCountryAddInfo")
    Integer bankCountryAddInfo(BankDTO bankDTO);
    class BankCountryAddInfo {
        public String bankCountryAddInfo(BankDTO bankDTO) {
            SQL sql = new SQL();
            sql.INSERT_INTO("bank_tb");
            sql.VALUES("bankId", "#{bankId}");
            sql.VALUES("bankName", "#{bankName}");
            sql.VALUES("bankType", "#{bankType}");
            sql.VALUES("parentCode", "#{parentCode}");
            sql.VALUES("parentName", "#{parentName}");
            sql.VALUES("leafCode", "#{leafCode}");
            sql.VALUES("createTime", "#{createTime}");
            return sql.toString();

        }
    }
    @SelectProvider(type = BankMapper.BankQueryAll.class, method = "bankQueryAll")
    List<BankDTO> bankQueryAll(BankDTO bankDTO);
    class BankQueryAll {
        public String bankQueryAll(BankDTO bankDTO) {
            SQL sql = new SQL();
            sql.SELECT("bankId,bankName,bankType,parentCode,parentName,leafCode,createTime");
            sql.FROM("bank_tb");
            return sql.toString();
        }
    }

    @SelectProvider(type = BankMapper.bankQueryById.class, method = "bankQueryById")
    List<BankDTO> bankQueryById(BankDTO bankDTO);
    class bankQueryById {
        public String bankQueryById(BankDTO bankDTO) {
            SQL sql = new SQL();
            sql.SELECT("bankId,bankName,bankType,parentCode,parentName,leafCode,createTime");
            sql.FROM("bank_tb");
            sql.WHERE("bankId=#{bankId}");
            return sql.toString();
        }
    }

    @DeleteProvider(type = BankMapper.BankInfoRemove.class,method = "bankInfoRemove")
    Integer bankInfoRemove(BankDTO bankDTO);
    class BankInfoRemove{
        public String bankInfoRemove(BankDTO BankDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("bank_tb");
            sql.WHERE("bankId=#{bankId}");
            return  sql.toString();
        }
    }

    @SelectProvider(type = BankMapper.bankQueryPage.class, method = "bankQueryPage")
    List<BankDTO> bankQueryPage(BankDTO bankDTO);
    class bankQueryPage {
        public String bankQueryPage(BankDTO bankDTO) {
            SQL sql = new SQL();
            sql.SELECT("bankId,bankName,bankType,parentCode,parentName,leafCode,createTime");
            sql.FROM("bank_tb");
            if(!bankDTO.getBankId().equals("root")){
            if (bankDTO.getBankId() != null) {
                sql.WHERE("bankId=#{bankId}");
            }
//            if(bankDTO.getBankName()!=null){
//            sql.WHERE("bankName=#{bankName}");
//            }
//            if(bankDTO.getBankType()!=null){
//            sql.WHERE("bankType=#{bankType}");
//            }
//            if(bankDTO.getParentCode()!=null){
//            sql.WHERE("parentCode=#{parentCode}");
//            }
//            if(bankDTO.getParentName()!=null){
//            sql.WHERE("parentName=#{parentName}");
//            }
//            if(bankDTO.getLeafCode()!=null){
//            sql.WHERE("leafCode=#{leafCode}");
//            }
            }
            StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append(sql.toString());
           stringBuilder.append(" LIMIT #{bankPagation.currentPage},#{bankPagation.pageSize}");
            return stringBuilder.toString();

        }
    }

    @UpdateProvider(type = BankMapper.bankInfoUpdate.class, method = "bankInfoUpdate")
    Integer bankInfoUpdate(BankDTO bankDTO);
    class bankInfoUpdate {
        public String bankInfoUpdate(BankDTO bankDTO) {
            SQL sql = new SQL();
            sql.UPDATE("bank_tb");
            if(bankDTO.getBankId()!=null){
            sql.SET("bankId = #{bankId}");
            }
            if(bankDTO.getBankName()!=null){
            sql.SET("bankName = #{bankName}");
            }
            if(bankDTO.getBankType()!=null){
            sql.SET("bankType = #{bankType}");
            }
            if(bankDTO.getParentCode()!=null){
            sql.SET("parentCode = #{parentCode}");
            }
            if(bankDTO.getParentName()!=null){
            sql.SET("parentName = #{parentName}");
            }
            if(bankDTO.getLeafCode()!=null){
            sql.SET("leafCode = #{leafCode}");
            }
            if(bankDTO.getCreateTime()!=null){
                sql.SET("createTime = #{createTime}");
            }
            sql.WHERE("bankId = #{bankId}");
            return sql.toString();

        }
    }
}
