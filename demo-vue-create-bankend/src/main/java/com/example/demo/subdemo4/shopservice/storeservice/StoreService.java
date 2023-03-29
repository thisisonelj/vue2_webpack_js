package com.example.demo.subdemo4.shopservice.storeservice;

import com.example.demo.subdemo4.shopdto.storedto.GoodDTO;
import com.example.demo.subdemo4.shopdto.storedto.StoreDTO;

import java.util.HashMap;
import java.util.List;

public interface StoreService {
    Boolean storeAddInfo(StoreDTO storeDTO);//添加店铺货物信息
    List<StoreDTO> storeQueryAllInfo();//查询所有店铺信息
    List<GoodDTO> goodQueryAllInfo();//查询所有货物信息
    HashMap<String,Object> QueryAllInfo();//查询所有店铺货物信息
    List<GoodDTO> queryGoodByStoreId(StoreDTO storeDTO);//通过店铺Id来查询对应货物信息
    List<GoodDTO> queryGoodByStoreIdList(List<StoreDTO> storeDTOList);//通过店铺Id列表来查询对应货物信息
    Boolean goodRemoveInfo(GoodDTO goodDTO);//删除货物信息根据id
    Boolean goodsUpdateInfo(List<GoodDTO> goodDTOList);//修改货物信息根据id列表
    Boolean storeUpdateInfo(StoreDTO storeDTO);//修改店铺信息根据id
    Boolean storeRemoveInfo(StoreDTO storeDTO);//删除店铺信息根据id
}
