package com.example.demo.subdemo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;
    public void PersonHander(){
        PersonPojo personPojo=new PersonPojo();
        personPojo.setId(3);
        Log log = LogFactory.getLog(PersonService.class);
        log.info(personMapper.queryPersonById(personPojo));
    }

}
