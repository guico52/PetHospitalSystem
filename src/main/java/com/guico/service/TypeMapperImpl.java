package com.guico.service;

import com.guico.dao.mapper.TypeMapper;
import com.guico.dao.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeMapperImpl implements TypeMapper {
    @Autowired
    private TypeMapper typeMapper;

    public void setTypeMapper(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    @Override
    public List<Type> selectAll() {
        return typeMapper.selectAll();
    }

    @Override
    public Type selectById(int id) {
        return typeMapper.selectById(id);
    }

    @Override
    public int insertType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public int deleteById(int id) {
        return typeMapper.deleteById(id);
    }
}

