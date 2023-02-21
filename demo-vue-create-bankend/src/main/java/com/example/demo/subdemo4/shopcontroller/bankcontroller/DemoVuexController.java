package com.example.demo.subdemo4.shopcontroller.bankcontroller;

import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopeneity.VuexActions;
import com.example.demo.subdemo4.shoputils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/rest/demo/vuex")
@RestController

@CrossOrigin
public class DemoVuexController {
    @PostMapping("/actions")
    public ResultUtil<Object> vuexActions(@RequestBody VuexActions vuexActions) {
        List<VuexActions> list = new ArrayList<>();
        for(int i=0;i<=vuexActions.getSize();i++){
            VuexActions vuexActions1=new VuexActions();
            vuexActions1.setName("liusir");
            vuexActions1.setAge(24);
            vuexActions1.setIndex(i);
            list.add(vuexActions1);
        }
        return ResultUtil.resultSuccessful(list);
    }
}
