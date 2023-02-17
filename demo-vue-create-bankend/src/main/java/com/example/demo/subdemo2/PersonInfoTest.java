package com.example.demo.subdemo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonInfoTest {
    @Autowired
    private PersonMapper personMapper;
    @Bean
    public void testPerson(){
        PersonPojo personPojo=new PersonPojo();
        personPojo.setId(3);
        Log log = LogFactory.getLog(PersonService.class);
        log.info(personMapper.queryPersonById(personPojo));
    }

}
