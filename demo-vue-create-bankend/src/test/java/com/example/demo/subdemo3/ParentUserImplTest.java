package com.example.demo.subdemo3;

import com.example.demo.subdemo2.PersonPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ParentUserImplTest {
    @Autowired
    private ParentUserImpl parentUser;

    @Test
    void queryParentInfo() {
        Log log = LogFactory.getLog(ParentUserImplTest.class);
        log.info(parentUser.queryParentInfo());
    }
}