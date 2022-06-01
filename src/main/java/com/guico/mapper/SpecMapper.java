package com.guico.mapper;


import com.guico.pojo.Spec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecMapper {
    List selectAll();
    Spec selectById(int id);
    Spec selectByName(String name);
    Spec selectByNameAndId(String name,int id);
    int deleteById(int id);
    int insertSpec(Spec spec);
    int updateSpec(Spec spec);

}
