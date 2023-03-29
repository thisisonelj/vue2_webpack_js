package com.example.demo.subdemo4.shopcontroller.storecontroller;

import com.example.demo.subdemo4.shopdto.storedto.GoodDTO;
import com.example.demo.subdemo4.shopdto.storedto.StoreDTO;
import com.example.demo.subdemo4.shopserviceimpl.storeserviceimpl.StoreServiceImpl;
import com.example.demo.subdemo4.shoputils.ResultUtil;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/rest/demo/store")
@RestController

@CrossOrigin
public class StoreController {
    @Autowired
    private StoreServiceImpl storeServiceImpl;
    /*
   注册添加店铺货物信息
    */
    @PostMapping("/add")
    public ResultUtil<Object> storeAdd(@RequestBody StoreDTO storeDTO) {
      if(storeServiceImpl.storeAddInfo(storeDTO)==true){
          return ResultUtil.resultSuccessful(200,"数据添加成功",true);
       }
        return ResultUtil.resultFailure(200,"数据添加失败",false);
    }
    /*
    查询所有店铺信息
     */
    @PostMapping("/querystores")
    public ResultUtil<Object> storeAllQuery() {
       return ResultUtil.resultSuccessful(200,"获取店铺列表成功",storeServiceImpl.storeQueryAllInfo());
    }
    /*
    查询所有货物信息
     */
    @PostMapping("/querygoods")
    public ResultUtil<Object> goodAllQuery() {
        return ResultUtil.resultSuccessful(200,"获取货物列表成功",storeServiceImpl.goodQueryAllInfo());
    }

    /*
   查询所有店铺货物信息
    */
    @PostMapping("/queryall")
    public ResultUtil<Object> AllQuery() {
        return ResultUtil.resultSuccessful(200,"获取店铺货物列表成功",storeServiceImpl.QueryAllInfo());
    }

    /*
   根据店铺Id来查询对应货物信息
    */
    @PostMapping("/querybystoreid")
    public ResultUtil<Object> queryGoodsByStoreId(@RequestBody StoreDTO storeDTO) {
        return ResultUtil.resultSuccessful(200,"获取店铺对应货物列表成功",storeServiceImpl.queryGoodByStoreId(storeDTO));
    }

    /*
   根据货物id删除货物信息
   */
    @PostMapping("/deletebygoodid")
    public ResultUtil<Object> deleteByGoodId(@RequestBody GoodDTO goodDTO) {
        if(storeServiceImpl.goodRemoveInfo(goodDTO)==true){
            return ResultUtil.resultSuccessful(200,"删除货物数据成功",goodDTO.getId());
        }else{
            return ResultUtil.resultFailure(200,"删除货物数据失败",goodDTO.getId());
        }

    }

    /*
      根据货物id列表修改货物信息
    */
    @PostMapping("/updatebygoodidlist")
    public ResultUtil<Object> updateByGoodId(@RequestBody List<GoodDTO> goodDTOList) {
        if(storeServiceImpl.goodsUpdateInfo(goodDTOList)==true){
            return ResultUtil.resultSuccessful(200,"修改货物数据成功",goodDTOList.stream().map(e -> {return e.getId();}).collect(Collectors.toList()));
        }else{
            return ResultUtil.resultFailure(200,"修改货物数据失败",goodDTOList.stream().map(e -> {return e.getId();}).collect(Collectors.toList()));
        }

    }

    /*
     根据店铺Id列表来查询对应货物信息
   */
    @PostMapping("/querybystoreidlist")
    public ResultUtil<Object> queryGoodsByStoreIdList(@RequestBody List<StoreDTO> storeDTOList) {
        return ResultUtil.resultSuccessful(200,"获取店铺标识列表对应货物列表成功",storeServiceImpl.queryGoodByStoreIdList(storeDTOList));
    }

    /*
      根据店铺id修改店铺信息
    */
    @PostMapping("/updatebystoreid")
    public ResultUtil<Object> updateByStoreId(@RequestBody StoreDTO storeDTO) {
        if(storeServiceImpl.storeUpdateInfo(storeDTO)==true){
            return ResultUtil.resultSuccessful(200,"修改店铺数据成功",storeDTO.getId());
        }else{
            return ResultUtil.resultFailure(200,"修改店铺数据失败",storeDTO.getId());
        }

    }

    /*
     根据店铺id删除店铺信息
   */
    @PostMapping("/deletebystoreid")
    public ResultUtil<Object> deleteByStoreId(@RequestBody StoreDTO storeDTO) {
        if(storeServiceImpl.storeRemoveInfo(storeDTO)==true){
            return ResultUtil.resultSuccessful(200,"删除店铺数据成功",storeDTO.getId());
        }else{
            return ResultUtil.resultFailure(200,"删除店铺数据失败",storeDTO.getId());
        }

    }
}
