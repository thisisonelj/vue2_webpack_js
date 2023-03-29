package com.example.demo.subdemo4.shopcontroller.bankcontroller;

import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopdto.bankdto.SchemeBankDTO;
import com.example.demo.subdemo4.shopserviceimpl.bankserviceimpl.BankSchemeServiceImpl;
import com.example.demo.subdemo4.shoputils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rest/demo/bankscheme")
@RestController
@CrossOrigin
public class BankSchemeController {
    @Autowired
    private BankSchemeServiceImpl bankSchemeServiceImpl;
    @PostMapping("/add")
    public ResultUtil<Object> bankSchemeAdd(@RequestBody SchemeBankDTO schemeBankDTO) {
      String id =  bankSchemeServiceImpl.bankSchemeAdd(schemeBankDTO);
        return id != null
                ? ResultUtil.resultSuccessful(200,"数据添加成功",id)
                : ResultUtil.resultFailure(500, "数据添加错误");
    }
    @PostMapping("/query-all")
    public ResultUtil<Object> bankSchemeQueryAll(@RequestBody SchemeBankDTO schemeBankDTO) {
        return ResultUtil.resultSuccessful(bankSchemeServiceImpl.schemeQueryAll(schemeBankDTO));
    }

    @PostMapping("/querybyschemeid")
    public ResultUtil<Object> bankSchemeQueryById(@RequestBody SchemeBankDTO schemeBankDTO) {
        return ResultUtil.resultSuccessful(bankSchemeServiceImpl.schemeQueryById(schemeBankDTO));
    }

    @PostMapping("/updatebyschemeid")
    public ResultUtil<Object> bankSchemeUpdateById(@RequestBody SchemeBankDTO schemeBankDTO) {
        return ResultUtil.resultSuccessful(bankSchemeServiceImpl.bankSchememUpdate(schemeBankDTO));
    }

    @PostMapping("/deletebyschemeid")
    public ResultUtil<Object> bankSchemeDeleteById(@RequestBody List<SchemeBankDTO> schemeBankDTOList) {
        return ResultUtil.resultSuccessful(bankSchemeServiceImpl.bankSchememDelete(schemeBankDTOList));
    }

    @PostMapping("/selectbyscheme")
    public ResultUtil<Object> bankSchemeSelectByScheme(@RequestBody SchemeBankDTO schemeBankDTO) {
        return ResultUtil.resultSuccessful(bankSchemeServiceImpl.selectScheme(schemeBankDTO));
    }
}
