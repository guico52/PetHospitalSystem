package com.guico.service;

import com.guico.mapper.EmpMapper;
import com.guico.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpMapperImpl implements EmpMapper {

    @Autowired
    EmpMapper empMapper;

    //setter
    public void setEmpMapper(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    public Emp selectEmpByName(String name) {
        return empMapper.selectEmpByName(name);
    }

    public List selectAll() {
        return empMapper.selectAll();
    }

    public int insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    public int updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    public int deleteById(Integer id) {
        return empMapper.deleteById(id);
    }

    public boolean checkEmpLogin(String name, String password) {
        Emp emp = empMapper.selectEmpByName(name);
        return emp!=null && emp.getPassword().equals(password);
    }

    public boolean checkEmpRegisterName(String name) {
        Emp emp = empMapper.selectEmpByName(name);
        return emp==null;
    }


}
