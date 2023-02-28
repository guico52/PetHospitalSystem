package com.guico.dao.mapper;

import com.guico.dao.pojo.PetVisit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetVisitMapper {
    @Select("select * from visits")
    List<PetVisit> selectAll();

    @Select("select * from visits where id = #{petVistId}")
    PetVisit selectById(int id);

    @Insert("insert into visits(id, pet_id, visit_date, vdescription) VALUES (#{petVisitId}, #{petId}, #{petVisitDate}, #{petVisitDescription})")
    int insertVisit(PetVisit petVisit);

    @Select("select * from visits where pet_id = #{petId}")
    List<PetVisit> selectByPetId(int petId);

    @Update("update visits set pet_id=#{petId}, visit_date=#{petVisitDate}, vdescription=#{petVistDescription} where id=#{petVisitId}")
    int updateVisit(PetVisit petVisit);

    @Delete("delete from visits where id=#{petVisitId}")
    int deleteById(int id);
}
