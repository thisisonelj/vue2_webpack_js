package com.example.demo.subdemo4.shopserviceimpl.bankserviceimpl;

import com.example.demo.subdemo4.shopMapper.BankSchemeMapper;
import com.example.demo.subdemo4.shopdto.bankdto.BankDTO;
import com.example.demo.subdemo4.shopdto.bankdto.SchemeBankDTO;
import com.example.demo.subdemo4.shopservice.bankservice.BankSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankSchemeServiceImpl implements BankSchemeService {
    @Autowired
    private BankSchemeMapper bankSchemeMapper;
    @Override
    public String bankSchemeAdd(SchemeBankDTO schemeBankDTO) {
        final UUID schemeId = UUID.randomUUID();
        schemeBankDTO.setSchemeId(schemeId.toString());
        bankSchemeMapper.schemeBankAdd(schemeBankDTO);
        return schemeBankDTO.getSchemeId();
    }

    @Override
    public List<SchemeBankDTO> schemeQueryAll(SchemeBankDTO schemeBankDTO) {
        return bankSchemeMapper.schemeBankQueryAll(schemeBankDTO);
    }

    @Override
    public SchemeBankDTO schemeQueryById(SchemeBankDTO schemeBankDTO) {
        return bankSchemeMapper.schemeBankQueryById(schemeBankDTO);
    }

    @Override
    public String bankSchememUpdate(SchemeBankDTO schemeBankDTO) {
         bankSchemeMapper.schemeBankUpdateById(schemeBankDTO);
         String id=schemeBankDTO.getSchemeId();
         return  id;

    }

    @Override
    public String bankSchememDelete(List<SchemeBankDTO> schemeBankDTOList) {
        for(SchemeBankDTO schemeBankDTO:schemeBankDTOList){
            bankSchemeMapper.schemeBankDeleteById(schemeBankDTO);
        }
        return "删除方案成功";
    }

    @Override
    public List<BankDTO> selectScheme(SchemeBankDTO schemeBankDTO) {
        return bankSchemeMapper.selectByScheme(schemeBankDTO);
    }
}
