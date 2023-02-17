package com.example.demo.subdemo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonMapper personMapper;

    @Test
    void personHander() {
        PersonPojo personPojo=new PersonPojo();
        personPojo.setId(3);
        Log log = LogFactory.getLog(PersonService.class);
        log.info(personMapper.queryPersonById(personPojo));
    }
}