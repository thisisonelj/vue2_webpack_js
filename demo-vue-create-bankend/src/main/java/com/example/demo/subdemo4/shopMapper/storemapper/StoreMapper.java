package com.example.demo.subdemo4.shopMapper.storemapper;

import com.example.demo.subdemo4.shopMapper.BankMapper;
import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopdto.storedto.GoodDTO;
import com.example.demo.subdemo4.shopdto.storedto.StoreDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StoreMapper {
    //注册添加店铺信息
    @InsertProvider(type = StoreMapper.StoreAddInfo.class, method = "storeAddInfo")
    Integer storeAddInfo(StoreDTO storeDTO);
    class StoreAddInfo {
        public String storeAddInfo(StoreDTO storeDTO) {
            SQL sql = new SQL();
            sql.INSERT_INTO("store_tb");
            sql.VALUES("id", "#{id}");
            sql.VALUES("storeId", "#{storeId}");
            sql.VALUES("storeName", "#{storeName}");
            sql.VALUES("createTime", "#{createTime}");
            sql.VALUES("parentId", "#{parentId}");
            return sql.toString();

        }
    }
    //注册添加货物信息
    @InsertProvider(type = StoreMapper.GoodAddInfo.class, method = "goodAddInfo")
    Integer goodAddInfo(GoodDTO goodDTO);
    class GoodAddInfo {
        public String goodAddInfo(GoodDTO goodDTO) {
            SQL sql = new SQL();
            sql.INSERT_INTO("good_tb");
            sql.VALUES("id", "#{id}");
            sql.VALUES("goodId", "#{goodId}");
            sql.VALUES("goodName", "#{goodName}");
            sql.VALUES("storeId", "#{storeId}");
            sql.VALUES("createTime", "#{createTime}");
            return sql.toString();

        }
    }
   /*
   查询所有店铺信息
    */
    @SelectProvider(type = StoreMapper.StoreQueryAllInfo.class,method = "storeQueryAllInfo")
    List<StoreDTO> storeQueryAllInfo();
    class StoreQueryAllInfo {
        public String storeQueryAllInfo() {
            SQL sql = new SQL();
            sql.SELECT("id,storeId,storeName,createTime,parentId");
            sql.FROM("store_tb");
            return sql.toString();
        }
    }
    /*
      查询所有货物信息
       */
    @SelectProvider(type = StoreMapper.GoodQueryAllInfo.class,method = "goodQueryAllInfo")
    List<GoodDTO> goodQueryAllInfo();
    class GoodQueryAllInfo {
        public String goodQueryAllInfo() {
            SQL sql = new SQL();
            sql.SELECT("id,goodId,goodName,storeId,createTime");
            sql.FROM("good_tb");
            return sql.toString();
        }
    }
    /*
        根据店铺Id查询所有货物信息
     */
    @SelectProvider(type = StoreMapper.QueryGoodByStoreId.class,method = "queryGoodByStoreId")
    List<GoodDTO> queryGoodByStoreId(StoreDTO storeDTO);
    class QueryGoodByStoreId {
        public String queryGoodByStoreId() {
            SQL sql = new SQL();
            sql.SELECT("good_tb.id,good_tb.goodId,good_tb.goodName,good_tb.storeId,good_tb.createTime");
            sql.FROM("store_tb");
            sql.INNER_JOIN("good_tb on store_tb.storeId = good_tb.storeId");
            sql.WHERE("store_tb.storeId=#{storeId}");
            return sql.toString();
        }
    }
    /*
      根据货物id删除货物信息
    */
    @DeleteProvider(type = StoreMapper.GoodInfoRemove.class,method = "goodInfoRemove")
    Integer goodInfoRemove(GoodDTO goodDTO);
    class GoodInfoRemove{
        public String goodInfoRemove(GoodDTO goodDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("good_tb");
            sql.WHERE("id=#{id}");
            return  sql.toString();
        }
    }

    /*
     根据货物id修改货物信息
   */
    @UpdateProvider(type = StoreMapper.GoodInfoUpdate.class, method = "goodInfoUpdate")
    Integer goodInfoUpdate(GoodDTO goodDTO);
    class GoodInfoUpdate{
        public String goodInfoUpdate(GoodDTO goodDTO){
            SQL sql=new SQL();
            sql.UPDATE("good_tb");
            sql.SET("id=#{id}");
            sql.SET("goodId=#{goodId}");
            sql.SET("goodName=#{goodName}");
            sql.SET("storeId=#{storeId}");
            sql.SET("createTime=#{createTime}");
            sql.WHERE("id=#{id}");
            return  sql.toString();
        }
    }

    /*
    根据店铺id修改店铺信息
    */
    @UpdateProvider(type = StoreMapper.StoreInfoUpdate.class, method = "storeInfoUpdate")
    Integer storeInfoUpdate(StoreDTO storeDTO);
    class StoreInfoUpdate{
        public String storeInfoUpdate(StoreDTO storeDTO){
            SQL sql=new SQL();
            sql.UPDATE("store_tb");
            sql.SET("id=#{id}");
            sql.SET("storeId=#{storeId}");
            sql.SET("storeName=#{storeName}");
            sql.SET("parentId=#{parentId}");
            sql.SET("createTime=#{createTime}");
            sql.WHERE("id=#{id}");
            return  sql.toString();
        }
    }

    /*
      根据店铺id删除店铺信息
    */
    @DeleteProvider(type = StoreMapper.StoreInfoRemove.class,method = "storeInfoRemove")
    Integer storeInfoRemove(StoreDTO storeDTO);
    class StoreInfoRemove{
        public String storeInfoRemove(StoreDTO storeDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("store_tb");
            sql.WHERE("id=#{id}");
            return  sql.toString();
        }
    }

    /*
     根据店铺storeId删除货物信息
   */
    @DeleteProvider(type = StoreMapper.GoodInfoRemoveByStoreId.class,method = "goodInfoRemoveByStoreId")
    Integer goodInfoRemoveByStoreId(StoreDTO storeDTO);
    class GoodInfoRemoveByStoreId{
        public String goodInfoRemoveByStoreId(StoreDTO storeDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("good_tb");
            sql.WHERE("storeId=#{storeId}");
            return  sql.toString();
        }
    }

    /*
       根据店铺Id、创建时间查询所有货物信息
    */
    @SelectProvider(type = StoreMapper.QueryGoodsByStoreId.class,method = "queryGoodsByStoreId")
    List<StoreDTO> queryGoodsByStoreId(StoreDTO storeDTO);
    class QueryGoodsByStoreId {
        public String queryGoodsByStoreId() {
            SQL sql = new SQL();
            sql.SELECT("store_tb.id,store_tb.storeId,store_tb.storeName,store_tb.parentId");
            sql.SELECT("good_tb.id as aliaId,good_tb.goodId,good_tb.goodName,good_tb.createTime");
            sql.FROM("store_tb");
            sql.INNER_JOIN("good_tb on store_tb.storeId = good_tb.storeId");
            sql.WHERE("store_tb.storeId=#{storeId}");
            sql.WHERE("good_tb.createTime between #{startTime} and #{endTime}");
            return sql.toString();
        }
    }
}
