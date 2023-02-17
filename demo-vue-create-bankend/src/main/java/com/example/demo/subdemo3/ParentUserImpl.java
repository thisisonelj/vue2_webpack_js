package com.example.demo.subdemo3;

import com.example.demo.subdemo2.PersonPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParentUserImpl implements ParentInterface {
    @Autowired
    private ParentMapper parentMapper;

    @Override
    public List<UserInfo> queryParentInfo() {
        Log log = LogFactory.getLog(ParentUserImpl.class);
        PersonPojo personPojo = new PersonPojo();
        personPojo.setId(3);
        log.info(parentMapper.queryUserInfo(personPojo));
        return parentMapper.queryUserInfo(personPojo);
    }
}
