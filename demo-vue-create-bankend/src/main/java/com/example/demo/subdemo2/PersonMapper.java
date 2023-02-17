package com.example.demo.subdemo2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PersonMapper {
    @SelectProvider(type = PersonHander.class,method = "queryPersonById")
    List<PersonPojo> queryPersonById(PersonPojo personPojo);

    class PersonHander{
        public String queryPersonById(){
            SQL sql=new SQL();
            sql.SELECT("person.id,person.name");
            sql.FROM("personpojo as person");
            sql.WHERE("person.id=#{id}");
            return sql.toString();
        }
    }

}
