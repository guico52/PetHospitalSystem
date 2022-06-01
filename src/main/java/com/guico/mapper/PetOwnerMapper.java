package com.guico.mapper;

import com.guico.pojo.PetOwner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PetOwnerMapper {
    PetOwner selectPetOwnerByPetOwnerId(int PetOwnerId);
    List selectAll();
    int insertPetOwner(PetOwner petOwner);
    int updatePetOwner(PetOwner petOwner);
    int deletePetOwnerByPetOwnerId(int PetOwnerId);
}
