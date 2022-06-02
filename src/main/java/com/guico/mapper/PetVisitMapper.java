package com.guico.mapper;

import com.guico.pojo.PetVisit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetVisitMapper {
    @Select("select * from visits")
    List<PetVisit> selectAll();

    @Select("select * from visits where id = #{id}")
    PetVisit selectById(int id);

    @Insert("insert into visits(id, pet_id, visit_date, vdescription) VALUES (#{id}, #{petId}, #{visitDate}, #{description})")
    int insertVisit(PetVisit petVisit);

    @Select("select * from visits where pet_id = #{petId}")
    PetVisit selectByPetId(int petId);

    @Update("update visits set pet_id=#{petId}, visit_date=#{visitDate}, vdescription=#{description} where id=#{id}")
    int updateVisit(PetVisit petVisit);

    @Delete("delete from visits where id=#{id}")
    int deleteById(int id);
}
