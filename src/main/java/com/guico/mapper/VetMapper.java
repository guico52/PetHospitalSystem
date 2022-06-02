package com.guico.mapper;

import com.guico.pojo.Vet;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface VetMapper {
    @Select("select * from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id")
    List<Vet> selectAll();

    @Select("select * from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and v.id=#{id}")
    Vet selectById(int id);

    @Select("select * from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and v.name=#{name}")
    Vet selectByName(String name);

    @Delete("delete from vets where id=#{id}")
    int deleteById(int id);

    @Insert("insert into vets(id, name) VALUES (#{id}, #{name})")
    int insertVet(Vet vet);

    @Update("update vets set name=#{name} where id=#{id}")
    int updateVet(Vet vet);

    @Select("select * from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.id = #{id}")
    ArrayList<Vet> selectVetBySpecId(int id);

    @Select("select * from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.name = #{name}")
    ArrayList<Vet> selectVetBySpecName(String name);
}
