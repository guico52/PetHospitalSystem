package com.guico.mapper;

import com.guico.pojo.PetVisit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PetVisitMapper {
    List selectAll();
    PetVisit selectById(int id);
    int insertVisit(PetVisit petVisit);
    PetVisit selectByPetId(int petId);
    int updateVisit(PetVisit petVisit);
    int deleteById(int id);
}
