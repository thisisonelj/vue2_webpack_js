package com.example.demo.subdemo4.shopserviceimpl.bankserviceimpl;

import com.example.demo.subdemo4.shopMapper.BankMapper;
import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopservice.bankservice.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankMapper bankMapper;
    @Override
    public int bankAddInfo(BankDTO bankDTO) {
        final UUID bankId = UUID.randomUUID();
        bankDTO.setBankId(bankId.toString());
        Date currentTime=new Date();
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finalTime=sm.format(currentTime);
        bankDTO.setCreateTime(currentTime);
        return    bankMapper.bankCountryAddInfo(bankDTO);
    }

    @Override
    public List<BankDTO> bankQueryAllInfo(BankDTO bankDTO) {

        return bankMapper.bankQueryAll(bankDTO);
    }

    @Override
    public int bankDeleteInfo(List<BankDTO> bankDTOList) {
        int size=0;
       for(BankDTO bankDTO:bankDTOList){
         size+=bankMapper.bankInfoRemove(bankDTO);
       }
       return  size;
    }

    @Override
    public List<BankDTO> bankQueryPagetion(BankDTO bankDTO) {
       bankDTO.getBankPagation().setCurrentPage((bankDTO.getBankPagation().getCurrentPage() - 1)*bankDTO.getBankPagation().getPageSize());
       return bankMapper.bankQueryPage(bankDTO);
    }

    @Override
    public List<BankDTO> bankQuerySingle(BankDTO bankDTO) {
        return bankMapper.bankQueryById(bankDTO);
    }

    @Override
    public int bankUpdateInfo(BankDTO bankDTO) {
        return bankMapper.bankInfoUpdate(bankDTO);
    }
}
