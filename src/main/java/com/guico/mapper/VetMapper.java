package com.guico.mapper;

import com.guico.pojo.Vet;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface VetMapper {

    @ResultType(Vet.class)
    @Select("select  v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id")
    @Results(id="vetResult",value = {
            @Result(id = true, column = "v.id", property = "vetId"),
            @Result(column = "v.name", property = "vetName"),
            @Result(column = "s.id", property = "specId"),
            @Result(column = "s.name", property = "specName")
    })
    List<Vet> selectAll();

    @Select("select v.id vetId, v.name vetName, s.id specId, s.name specName from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and v.id=#{id}")
    @ResultMap("vetResult")
    Vet selectById(int id);

    @Select("select v.id, v.name, s.id, s.name from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and v.name=#{name}")
    @ResultMap("vetResult")
    Vet selectByName(String name);

    @Delete("delete from vets where id=#{vetID}")
    int deleteById(int id);

    @Insert("insert into vets(id, name) values(#{vetID}, #{vetName});" +
            "insert into vet_specialties(vet_id, specialty_id) values(#{vetID}, #{specID});")
    int insertVet(Vet vet);


    @Update("update vets set name=#{vetName} where id=#{vetID};" +
            "update vet_specialties set specialty_id=#{specID} where vet_id=#{vetID}")
    int updateVet(Vet vet);


    @Select("select v.id, v.name, s.id, s.name from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.id = #{id}")
    @ResultMap("vetResult")
    ArrayList<Vet> selectVetBySpecId(int id);


    @Select("select v.id, v.name, s.id, s.name from vets v, specialties s, vet_specialties vs where v.id=vs.vet_id and s.id=vs.specialty_id and s.name = #{name}")
    @ResultMap("vetResult")
    ArrayList<Vet> selectVetBySpecName(String name);
}
