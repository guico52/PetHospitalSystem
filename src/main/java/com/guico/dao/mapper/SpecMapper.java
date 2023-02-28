package com.guico.dao.mapper;


import com.guico.dao.pojo.Spec;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SpecMapper {
    @Select("select * from specialties")
    List<Spec> selectAll();

    @Select("select * from specialties where id = #{id}")
    Spec selectById(int id);

    @Select("select * from specialties where name = #{name}")
    Spec selectByName(String name);

    @Select("select * from specialties where name like #{name}")
    Spec selectByNameAndId(String name,int id);

    @Delete("delete from specialties where id=#{id}")
    int deleteById(int id);

    @Delete("delete from specialties where name=#{name}")
    int insertSpec(Spec spec);

    @Update("update specialties set name=#{name} where id=#{id}")
    int updateSpec(Spec spec);

}
