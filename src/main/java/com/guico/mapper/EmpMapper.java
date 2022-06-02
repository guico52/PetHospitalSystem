package com.guico.mapper;

import com.guico.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 根据对应的XML文件，实现对应的Mapper接口
 */
@Mapper
public interface EmpMapper {
    Emp selectEmpByName(String name);
    List selectAll();
    int insertEmp(Emp emp);
    int updateEmp(Emp emp);
    int deleteById(Integer id);
}
