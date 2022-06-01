package com.guico.mapper;

import com.guico.pojo.Vet;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface VetMapper {
    List selectAll();
    Vet selectById(int id);
    Vet selectByName(String name);
    int deleteById(int id);
    int insertVet(Vet vet);
    int updateVet(Vet vet);
    ArrayList selectVetBySpecId(int id);
    ArrayList selectVetBySpecName(String name);
}
