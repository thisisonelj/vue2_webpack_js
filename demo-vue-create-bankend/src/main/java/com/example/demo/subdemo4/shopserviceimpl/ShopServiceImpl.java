package com.example.demo.subdemo4.shopserviceimpl;

import com.example.demo.subdemo4.shopMapper.ShopMapper;
import com.example.demo.subdemo4.shopdto.ShopDBDTO;
import com.example.demo.subdemo4.shopdto.ShopDTO;
import com.example.demo.subdemo4.shopeneity.ShopUser;
import com.example.demo.subdemo4.shopservice.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    //   @Transactional
    @Override
    public int shopAddInfo(ShopDTO shopDTO) {

        if (shopMapper.shopAddInfo(shopDTO.getShopUser()) == 1
                &&
                shopMapper.shopGoodInfo(shopDTO.getShopGood()) == 1 &&
                shopMapper.shopStoreInfo(shopDTO.getShopStore()) == 1
        ) {
            return 3;
        } else {
            throw new RuntimeException("数据添加错误");
        }
    }

    @Override
    public List<ShopDBDTO> shopQueryInfo(ShopUser shopUser) {
        return shopMapper.shopContentQuery(shopUser);
    }

    @Override
    public List<ShopDBDTO> selectShopByUserId(ShopUser shopUser) {
        return shopMapper.selectShopByUserId(shopUser);
    }

    @Override
    public int shopRemove(ShopDBDTO shopDBDTO) {
        if (shopMapper.shopInfoRemove(shopDBDTO) == 1
                &&
                shopMapper.shopGoodRemove(shopDBDTO) == 1 &&
                shopMapper.shopStoreRemove(shopDBDTO) == 1
        ) {
            return 3;
        } else {
            throw new RuntimeException("数据删除错误");
        }
    }
}
