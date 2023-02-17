package com.example.demo.subdemo3;

import com.example.demo.subdemo2.PersonPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ParentMapper {
    @SelectProvider(type = ParentUserInfo.class,method = "queryUserInfo")
    List<UserInfo> queryUserInfo(PersonPojo personPojo);

    class ParentUserInfo {
      public String queryUserInfo() {
            SQL sql=new SQL();
            sql.SELECT("parent.name,parent.content,sub.name,sub.content,sub.intelegal");
            sql.FROM("personpojo person");
            sql.LEFT_OUTER_JOIN("parentuser parent on person.id=parent.parentId");
            sql.LEFT_OUTER_JOIN("subuser sub on parent.parentId=sub.subId");
            sql.WHERE("person.id=#{id}");
            sql.ORDER_BY("parent.parentId");
            return sql.toString();
        }
    }
}
