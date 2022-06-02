package com.guico.mapper;

import com.guico.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 根据对应的XML文件，实现对应的Mapper接口
 */
@Mapper
public interface EmpMapper {

    @Select("select * from employee where name = #{name}")
    Emp selectEmpByName(String name);

    @Select("select * from employee")
    List<Emp> selectAll();

    @Insert("insert into employee (name,password) values(#{name},#{password})")
    int insertEmp(Emp emp);

    @Update("update employee set name=#{name},password=#{password} where id=#{id}")
    int updateEmp(Emp emp);

    @Delete("delete from employee where id=#{id}")
    int deleteById(Integer id);
}
