package com.guico.service;

import com.guico.mapper.PetVisitMapper;
import com.guico.pojo.PetVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetVisitMapperImpl implements PetVisitMapper {
    @Autowired
    private PetVisitMapper petVisitMapper;

    public List selectAll() {
        return petVisitMapper.selectAll();
    }

    public PetVisit selectById(int id) {
        return petVisitMapper.selectById(id);
    }

    public int insertVisit(PetVisit petVisit) {
        return petVisitMapper.insertVisit(petVisit);
    }

    public PetVisit selectByPetId(int petId) {
        return petVisitMapper.selectByPetId(petId);
    }

    public int updateVisit(PetVisit petVisit) {
        return petVisitMapper.updateVisit(petVisit);
    }

    public int deleteById(int id) {
        return petVisitMapper.deleteById(id);
    }
}
