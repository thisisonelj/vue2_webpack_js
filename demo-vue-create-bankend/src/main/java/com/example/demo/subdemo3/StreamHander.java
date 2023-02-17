package com.example.demo.subdemo3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamHander {
    public static void main(String[] args) {
        List<ParentUser> userList=new ArrayList<>();
        ParentUser parentUser=new ParentUser();
        parentUser.setName("liu");
        parentUser.setId(1);
        ParentUser parentUser1=new ParentUser();
        parentUser1.setId(2);
        parentUser1.setName("liu1");
        ParentUser parentUser2=new ParentUser();
        parentUser2.setId(3);
        parentUser2.setName("liu2");
        userList.add(parentUser);
        userList.add(parentUser1);
        userList.add(parentUser2);
        List<ParentUser> finalList = userList.stream().map(item -> {
            item.setName("liu");
            return item;
        }).filter(item -> {return item.getId()==2;}).collect(Collectors.toList());
        Log log = LogFactory.getLog(StreamHander.class);
        log.info(finalList);

    }
}
