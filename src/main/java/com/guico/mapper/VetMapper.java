package com.guico.mapper;

import com.guico.pojo.Vet;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface VetMapper {


    @Select("select  v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id")
    List<Vet> selectAll();

    @Select("select v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and v.id=#{id}")
    Vet selectById(int id);

    @Select("select v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and v.name like CONCAT('%',#{vetName}, '%')")
    List<Vet> selectByName(@Param("vetName") String name);

    @Delete("delete from vets where id=#{vetID}")
    int deleteById(int id);

    @Insert("insert into vets(id, name) values(#{vetID}, #{vetName});" +
            "insert into vet_specialties(vet_id, specialty_id) values(#{vetID}, #{specID});")
    int insertVet(Vet vet);


    @Update("update vets set name=#{vetName} where id=#{vetID};" +
            "update vet_specialties set specialty_id=#{specID} where vet_id=#{vetID}")
    int updateVet(Vet vet);


    @Select("select v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.id = #{id}")
    List<Vet> selectVetBySpecId(int id);


    @Select("select v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.name like #{name}")
    List<Vet> selectVetBySpecName(String name);

    @Select("select v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.id = #{id} and v.name like CONCAT('%',#{name},'%')")
    List<Vet> selectVetBySpecAndName(@Param("id") int id,@Param("name") String name);

}
