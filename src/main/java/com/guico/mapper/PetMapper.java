package com.guico.mapper;

import com.guico.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 根据对应的XML文件，实现对应的Mapper接口
 */
@Mapper
public interface PetMapper {
    List selectAll();
    Pet selectById(int id);
    int insertPet(Pet pet);
    int updatePet(Pet pet);
    int deleteById(int id);
}


