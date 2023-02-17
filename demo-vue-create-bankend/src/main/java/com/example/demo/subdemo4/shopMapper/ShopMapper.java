package com.example.demo.subdemo4.shopMapper;

import com.example.demo.subdemo4.shopdto.ShopDBDTO;
import com.example.demo.subdemo4.shopeneity.ShopGood;
import com.example.demo.subdemo4.shopeneity.ShopStore;
import com.example.demo.subdemo4.shopeneity.ShopUser;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    @InsertProvider(type = ShopAddInfo.class, method = "shopAddInfo")
    Integer shopAddInfo(ShopUser shopUser);

    @InsertProvider(type = ShopGoodInfo.class, method = "shopGoodInfo")
    Integer shopGoodInfo(ShopGood shopGood);

    @InsertProvider(type = ShopStoreInfo.class, method = "shopStoreInfo")
    Integer shopStoreInfo(ShopStore shopStore);

    @SelectProvider(type = ShopContentQuery.class, method = "shopContentQuery")
    List<ShopDBDTO> shopContentQuery(ShopUser shopUser);
    @SelectProvider(type = SelectShopByUserId.class,method = "selectShopByUserId")
    List<ShopDBDTO> selectShopByUserId(ShopUser shopUser);
    @DeleteProvider(type = ShopInfoRemove.class,method = "shopInfoRemove")
    Integer shopInfoRemove(ShopDBDTO shopDBDTO);
    @DeleteProvider(type = ShopGoodRemove.class,method = "shopGoodRemove")
    Integer shopGoodRemove(ShopDBDTO shopDBDTO);
    @DeleteProvider(type = ShopStoreRemove.class,method = "shopStoreRemove")
    Integer shopStoreRemove(ShopDBDTO shopDBDTO);
    class ShopAddInfo {
        public String shopAddInfo(ShopUser shopUser) {
            SQL sql = new SQL();
            sql.INSERT_INTO("shopuser");
            sql.VALUES("user_id", "#{userId}");
            sql.VALUES("name", "#{name}");
            sql.VALUES("age", "#{age}");
            sql.VALUES("sex", "#{sex}");
            sql.VALUES("shop_date", "#{shopDate}");
            return sql.toString();

        }
    }

    class ShopGoodInfo {
        public String shopGoodInfo(ShopGood shopGood) {
            SQL sql = new SQL();
            sql.INSERT_INTO("storegood");
            sql.VALUES("good_Id", "#{goodId}");
            sql.VALUES("good_name", "#{goodName}");
            return sql.toString();
        }

    }


    class ShopStoreInfo {
        public String shopStoreInfo(ShopStore shopStore) {
            SQL sql = new SQL();
            sql.INSERT_INTO("shopstore");
            sql.VALUES("store_Id", "#{storeId}");
            sql.VALUES("store_name", "#{storeName}");
            return sql.toString();
        }
    }

    class ShopContentQuery {
        public String shopContentQuery(ShopUser shopUser) {
            SQL sql = new SQL();
            sql.SELECT("shopuser.name,shopuser.user_id as userId,shopuser.age,shopuser.sex,shopuser.shop_date as shopDate");
            sql.SELECT("storegood.good_id as goodId,storegood.good_name as goodName");
            sql.SELECT("shopstore.store_id as storeId,shopstore.store_name as storeName");
            sql.FROM("shopuser");
            sql.INNER_JOIN("shopstore on shopuser.user_id=shopstore.store_id");
            sql.INNER_JOIN("storegood on storegood.good_id=shopstore.store_id");
            if(shopUser.getUserId()!=null){
            sql.WHERE("shopuser.user_id=#{userId}");
            }
            sql.ORDER_BY("shopuser.user_id");
            return sql.toString();
        }
    }

    class SelectShopByUserId{
        public String selectShopByUserId(ShopUser shopUser){
            SQL sql=new SQL();
            sql.SELECT("user_id as userId");
            sql.FROM("shopuser");
            sql.WHERE("user_id=#{userId}");
            return sql.toString();
        }
    }
    class ShopInfoRemove{
        public String shopInfoRemove(ShopDBDTO shopDBDTO){
          SQL sql=new SQL();
          sql.DELETE_FROM("shopuser");
          sql.WHERE("user_id=#{userId}");
          return  sql.toString();
        }
    }
    class ShopGoodRemove{
        public String shopGoodRemove(ShopDBDTO shopDBDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("storegood");
            sql.WHERE("good_id=#{goodId}");
            return  sql.toString();
        }
    }
    class ShopStoreRemove{
        public String shopStoreRemove(ShopDBDTO shopDBDTO){
            SQL sql=new SQL();
            sql.DELETE_FROM("shopstore");
            sql.WHERE("store_id=#{storeId}");
            return  sql.toString();
        }
    }
}
