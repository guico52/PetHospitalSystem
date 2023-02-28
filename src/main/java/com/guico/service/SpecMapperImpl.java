package com.guico.service;

import com.guico.dao.mapper.SpecMapper;
import com.guico.dao.pojo.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecMapperImpl implements SpecMapper {

    @Autowired
    private SpecMapper specMapper;
//    setter
    public void setSpecMapper(SpecMapper specMapper) {
        this.specMapper = specMapper;
    }

    public List selectAll() {
        return specMapper.selectAll();
    }

    public Spec selectById(int id) {
        return specMapper.selectById(id);
    }

    public Spec selectByName(String name) {
        return specMapper.selectByName(name);
    }

    public Spec selectByNameAndId(String name, int id) {
        return specMapper.selectByNameAndId(name, id);
    }

    public int deleteById(int id) {
        return specMapper.deleteById(id);
    }

    public int insertSpec(Spec spec) {
        return specMapper.insertSpec(spec);
    }

    public int updateSpec(Spec spec) {
        return specMapper.updateSpec(spec);
    }
}
