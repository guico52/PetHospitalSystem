package com.guico.mapper;

import com.guico.pojo.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 根据对应的XML文件，实现对应的Mapper接口
 */
@Mapper
public interface PetMapper {
    @Results({
            @Result(column = "p.id", property = "id"),
            @Result(column = "p.name", property = "name"),
            @Result(column = "p.birth_date", property = "birthDate"),
            @Result(column = "t.id", property = "typeId"),
            @Result(column = "t.name", property = "typeName"),
            @Result(column = "o.id", property = "ownerId"),
            @Result(column = "o.name", property = "ownerName")

    })
    @Select("select p.id, p.name, p.birth_date, t.id, t.name, o.id, o.name from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id")
    List<Pet> selectAll();

    @Results({
            @Result(column = "p.id", property = "id"),
            @Result(column = "p.name", property = "name"),
            @Result(column = "p.birth_date", property = "birthDate"),
            @Result(column = "t.id", property = "typeId"),
            @Result(column = "t.name", property = "typeName"),
            @Result(column = "o.id", property = "ownerId"),
            @Result(column = "o.name", property = "ownerName")

    })
    @Select("select p.id, p.name, p.birth_date, t.id, t.name, o.id, o.name from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id and p.id=#{id}")
    Pet selectById(int id);


    @Insert("insert into pets(name,birth_date,type_id,owner_id) values(#{name},#{birthDate},#{typeId},#{ownerId});" +
            "")
    int insertPet(Pet pet);

    @Update("update pets set name=#{name}, birth_date=#{birthDate},type_id=#{typeId},owner_id=#{ownerId} where id=#{id}")
    int updatePet(Pet pet);
    @Delete("delete from pets where id=#{id}")
    int deleteById(int id);
}


