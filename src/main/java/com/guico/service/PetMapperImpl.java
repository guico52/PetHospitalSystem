package com.guico.service;

import com.guico.mapper.PetMapper;
import com.guico.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetMapperImpl implements PetMapper {
    @Autowired
    private PetMapper mapper;
//    setter
    public void setMapper(PetMapper mapper) {
        this.mapper = mapper;
    }

    public List selectAll() {
        return mapper.selectAll();
    }

    public Pet selectById(int id) {
        return mapper.selectById(id);
    }

    public int insertPet(Pet pet) {
        return mapper.insertPet(pet);
    }

    public int updatePet(Pet pet) {
        return mapper.updatePet(pet);
    }

    public int deleteById(int id) {
        return mapper.deleteById(id);
    }
}
