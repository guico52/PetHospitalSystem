package com.guico.service;

import com.guico.mapper.VetMapper;
import com.guico.pojo.Vet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VetMapperImpl implements VetMapper {
    @Autowired
    private VetMapper vetMapper;
//    setter
    public void setVetMapper(VetMapper vetMapper) {
        this.vetMapper = vetMapper;
    }


    public List selectAll() {
        return vetMapper.selectAll();
    }

    public Vet selectById(int id) {
        return vetMapper.selectById(id);
    }

    public Vet selectByName(String name) {
        return vetMapper.selectByName(name);
    }

    public int deleteById(int id) {
        return vetMapper.deleteById(id);
    }

    public int insertVet(Vet vet) {
        return vetMapper.insertVet(vet);
    }

    public int updateVet(Vet vet) {
        return vetMapper.updateVet(vet);
    }

    public ArrayList selectVetBySpecId(int id) {
        return vetMapper.selectVetBySpecId(id);
    }

    public ArrayList selectVetBySpecName(String name) {
        return vetMapper.selectVetBySpecName(name);
    }
}
