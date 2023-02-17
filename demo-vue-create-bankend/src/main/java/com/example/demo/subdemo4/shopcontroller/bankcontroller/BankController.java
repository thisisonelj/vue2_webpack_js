package com.example.demo.subdemo4.shopcontroller.bankcontroller;

import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopserviceimpl.bankserviceimpl.BankServiceImpl;
import com.example.demo.subdemo4.shoputils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rest/demo/bank")
@RestController

@CrossOrigin
public class BankController {
    @Autowired
    private BankServiceImpl bankServiceImpl;
    @PostMapping("/add")
    public ResultUtil<Object> bankAdd(@RequestBody BankDTO bankDTO) {
        return bankServiceImpl.bankAddInfo(bankDTO)== 1
                ? ResultUtil.resultSuccessful("数据添加成功")
                : ResultUtil.resultFailure(500, "数据添加错误");
    }

    @PostMapping("/query-all")
    public ResultUtil<Object> bankQueryAll(@RequestBody BankDTO bankDTO) {
        return ResultUtil.resultSuccessful(bankServiceImpl.bankQueryAllInfo(bankDTO));

    }

    @PostMapping("/delete")
    public ResultUtil<Object> bankDelete(@RequestBody List<BankDTO> bankDTOList) {
        return bankServiceImpl.bankDeleteInfo(bankDTOList)>0
                ? ResultUtil.resultSuccessful("数据删除成功")
                : ResultUtil.resultFailure(500, "数据删除错误");
    }

    @PostMapping("/pagation")
    public ResultUtil<Object> bankQueryPage(@RequestBody BankDTO bankDTO) {
        return ResultUtil.resultSuccessful(bankServiceImpl.bankQueryPagetion(bankDTO));

    }

    @PostMapping("/query-id")
    public ResultUtil<Object> bankQueryById(@RequestBody BankDTO bankDTO) {
        return ResultUtil.resultSuccessful(bankServiceImpl.bankQuerySingle(bankDTO));

    }

    @PostMapping("/update")
    public ResultUtil<Object> bankUpdate(@RequestBody BankDTO bankDTO) {
        return ResultUtil.resultSuccessful(bankServiceImpl.bankUpdateInfo(bankDTO));

    }
}
