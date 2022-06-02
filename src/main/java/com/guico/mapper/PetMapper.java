package com.guico.mapper;

import com.guico.pojo.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 根据对应的XML文件，实现对应的Mapper接口
 */
@Mapper
public interface PetMapper {
    @Select("select * from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id")
    List<Pet> selectAll();

    @Select("select * from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id and p.id=#{id}")
    Pet selectById(int id);

    @Insert("insert into pets(name,type_id,owner_id) values(#{name},#{typeId},#{ownerId})")
    int insertPet(Pet pet);

    @Update("update pets set name=#{name},type_id=#{typeId},owner_id=#{ownerId} where id=#{id}")
    int updatePet(Pet pet);
    @Delete("delete from pets where id=#{id}")
    int deleteById(int id);
}


