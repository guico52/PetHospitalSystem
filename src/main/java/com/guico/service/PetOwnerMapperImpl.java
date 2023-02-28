package com.guico.service;

import com.guico.dao.mapper.PetOwnerMapper;
import com.guico.dao.pojo.PetOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetOwnerMapperImpl implements PetOwnerMapper {

    @Autowired
    private PetOwnerMapper petOwnerMapper;
//    setter
    public void setPetOwnerMapper(PetOwnerMapper petOwnerMapper) {
        this.petOwnerMapper = petOwnerMapper;
    }

    public PetOwner selectPetOwnerByPetOwnerId(int PetOwnerId) {
        return petOwnerMapper.selectPetOwnerByPetOwnerId(PetOwnerId);
    }

    public List<PetOwner> selectAllPetOwners() {
        return petOwnerMapper.selectAllPetOwners();
    }

    public List<PetOwner> selectPetOwnerByName(String name) {
        return petOwnerMapper.selectPetOwnerByName(name);
    }

    public List<PetOwner> selectPetOwnerByPetName(String name) {
        return petOwnerMapper.selectPetOwnerByPetName(name);
    }


    public int insertPetOwner(PetOwner petOwner) {
        return petOwnerMapper.insertPetOwner(petOwner);
    }

    public int updatePetOwner(PetOwner petOwner) {
        return petOwnerMapper.updatePetOwner(petOwner);
    }

    public int deletePetOwnerByPetOwnerId(int PetOwnerId) {
        return petOwnerMapper.deletePetOwnerByPetOwnerId(PetOwnerId);
    }
}
