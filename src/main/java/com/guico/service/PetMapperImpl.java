package com.guico.service;

import com.guico.mapper.PetMapper;
import com.guico.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetMapperImpl implements PetMapper {
    @Autowired
    private PetMapper petMapper;


//    setter
    public void setPetMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    public List selectAll() {
        return petMapper.selectAll();
    }

    public Pet selectById(int id) {
        return petMapper.selectById(id);
    }

    public List<Pet> selectByName(String name) {
        return petMapper.selectByName(name);
    }

    public List<Pet> selectByOwnerName(String name) {
        return petMapper.selectByOwnerName(name);
    }

    public int insertPet(Pet pet) {
        return petMapper.insertPet(pet);
    }

    public int updatePet(Pet pet) {
        return petMapper.updatePet(pet);
    }

    public int deleteById(int id) {
        return petMapper.deleteById(id);
    }
}
