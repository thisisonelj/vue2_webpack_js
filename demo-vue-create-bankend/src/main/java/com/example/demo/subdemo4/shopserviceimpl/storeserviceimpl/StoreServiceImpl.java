package com.example.demo.subdemo4.shopserviceimpl.storeserviceimpl;

import com.example.demo.subdemo4.shopMapper.storemapper.StoreMapper;
import com.example.demo.subdemo4.shopdto.storedto.GoodDTO;
import com.example.demo.subdemo4.shopdto.storedto.StoreDTO;
import com.example.demo.subdemo4.shopservice.storeservice.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;
    /*
    完成注册插入店铺货物信息操作
     */
    @Override
    public Boolean storeAddInfo(StoreDTO storeDTO) {
        String storeById=UUID.randomUUID().toString();
        String goodById=UUID.randomUUID().toString();
        storeDTO.setId(storeById);//设置店铺主键uuid标识
        storeDTO.setParentId("root");//所有店铺子节点的父节点都是根节点
        GoodDTO goodDTO=storeDTO.getGoodDTO();
        goodDTO.setId(goodById);//设置货物主键uuid标识
        goodDTO.setStoreId(storeDTO.getStoreId());
        goodDTO.setCreateTime(storeDTO.getCreateTime());
        List<String> storeIdList=storeMapper.storeQueryAllInfo().stream().map(item -> {return item.getStoreId();}).collect(Collectors.toList());
        try {
            storeMapper.goodAddInfo(goodDTO);
            if (!storeIdList.contains(storeDTO.getStoreId())) {
                   storeMapper.storeAddInfo(storeDTO);
                   return true;
            }else{
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   /*
      查询所有店铺信息
    */
    @Override
    public List<StoreDTO> storeQueryAllInfo() {
        return storeMapper.storeQueryAllInfo();
    }
    /*
       查询所有货物信息
     */
    @Override
    public List<GoodDTO> goodQueryAllInfo() {
        return storeMapper.goodQueryAllInfo();
    }
     /*
     查询所有店铺货物信息
      */
    @Override
    public HashMap<String,Object> QueryAllInfo() {
      List<StoreDTO> storeDTOList=storeMapper.storeQueryAllInfo();
      List<GoodDTO>  goodDTOList=storeMapper.goodQueryAllInfo();
      HashMap<String,Object> unionMap=new HashMap<>();
      unionMap.put("store",storeDTOList);
      unionMap.put("good",goodDTOList);
      return unionMap;
    }
    /*
      根据店铺Id来查询对应货物信息
     */
    @Override
    public List<GoodDTO> queryGoodByStoreId(StoreDTO storeDTO) {
        if(storeDTO.getId().equals("root")){
            return storeMapper.goodQueryAllInfo();
        }
       return storeMapper.queryGoodByStoreId(storeDTO);
    }
    /*
      根据货物id删除货物信息
     */
    @Override
    public Boolean goodRemoveInfo(GoodDTO goodDTO) {
        if(storeMapper.goodInfoRemove(goodDTO)!=null){
            return true;
        }else{
            return false;
        }
    }
    /*
      根据货物id列表修改货物信息
     */
    @Override
    public Boolean goodsUpdateInfo(List<GoodDTO> goodDTOList) {
        try {
            goodDTOList.forEach(e -> {
                storeMapper.goodInfoUpdate(e);

            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     通过店铺Id列表来查询对应货物信息
    */
    @Override
    public List<GoodDTO> queryGoodByStoreIdList(List<StoreDTO> storeDTOList) {
        List<GoodDTO> goodDTOList=new ArrayList<>();
        storeDTOList.forEach(e ->{
            List<GoodDTO> goodDTOListItem=storeMapper.queryGoodByStoreId(e);
            goodDTOListItem.forEach(item ->{
                goodDTOList.add(item);
            });
        });
        return goodDTOList;
    }

    /*
       修改店铺信息根据id
    */
    @Override
    public Boolean storeUpdateInfo(StoreDTO storeDTO) {
        try {
            storeMapper.storeInfoUpdate(storeDTO);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
      删除店铺信息根据id
    */
    @Override
    public Boolean storeRemoveInfo(StoreDTO storeDTO) {
        try {
            storeMapper.storeInfoRemove(storeDTO);
            storeMapper.goodInfoRemoveByStoreId(storeDTO);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
      查询方案查询页面信息
     */
    @Override
    public List<StoreDTO> selectScheme(List<StoreDTO> storeDTOList) {
       List<StoreDTO> storeDTOS=new ArrayList<>();
        storeDTOList.forEach(item -> {
           List<StoreDTO> storeDTOList1= storeMapper.queryGoodsByStoreId(item);
           storeDTOList1.forEach(element -> {
               storeDTOS.add(element);
           });
        });
        return  storeDTOS;
    }
}
