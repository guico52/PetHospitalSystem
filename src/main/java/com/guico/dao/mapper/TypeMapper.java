package com.guico.dao.mapper;

import com.guico.dao.pojo.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Select("select * from types")
    List<Type> selectAll();

    @Select("select * from types where id = #{typeId}")
    Type selectById(int id);

    @Insert("insert into types(id, name) values(#{typeId}, #{typeName})")
    int insertType(Type type);

    @Delete("delete from types where id = #{typeId}")
    int deleteById(int id);
}
