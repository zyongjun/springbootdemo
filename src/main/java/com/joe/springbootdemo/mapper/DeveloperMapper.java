package com.joe.springbootdemo.mapper;

import com.joe.springbootdemo.pojo.Developer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "developerMapper")
public interface DeveloperMapper {
    @Select("select * from developer")
    List<Developer> getAllDevelopers();
    @Select("select * from developer where id = #{id}")
    Developer getDevelopers(String id);
    @Insert("insert into developer(name,site,avatar) values (#{name},#{site},#{avatar})")
    boolean addDeveloper(Developer developer);
    @Update("update developer set name = #{name},site = #{site},avatar = #{avatar} where id = #{id}")
    boolean updateDeveloper(Developer developer);
    @Delete("delete from developer where id = #{id}")
    boolean deleteDeveloper(String id);
}
