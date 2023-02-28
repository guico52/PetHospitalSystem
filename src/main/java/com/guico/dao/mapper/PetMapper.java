package com.guico.dao.mapper;

import com.guico.dao.pojo.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 根据对应的XML文件，实现对应的Mapper接口
 */
@Mapper
public interface PetMapper {

    @Select("select p.id id, p.name name, p.birth_date birthDate, t.id typeId, t.name typeName, o.id ownerId, o.name ownerName from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id")
    List<Pet> selectAll();


    @Select("select p.id id, p.name name, p.birth_date birthDate, t.id typeId, t.name typeName, o.id ownerId, o.name ownerName from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id and p.id=#{id}")
    Pet selectById(int id);

//    pet的模糊查询
    @Select("select p.id id, p.name name, p.birth_date birthDate, t.id typeId, t.name typeName, o.id ownerId, o.name ownerName from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id and p.name like concat('%',#{name},'%')")
    List<Pet> selectByName(@Param("name") String name);

//    pet根据主人名称的模糊链表查询
    @Select("select p.id id, p.name name, p.birth_date birthDate, t.id typeId, t.name typeName, o.id ownerId, o.name ownerName from pets p,types t, owners o where p.type_id=t.id and p.owner_id=o.id and o.name like concat('%',#{name},'%')")
    List<Pet> selectByOwnerName(@Param("name") String name);


    @Insert("insert into pets(name,birth_date,type_id,owner_id) values(#{name},#{birthDate},#{typeId},#{ownerId});")
    int insertPet(Pet pet);

    @Update("update pets set name=#{name}, birth_date=#{birthDate},type_id=#{typeId},owner_id=#{ownerId} where id=#{id}")
    int updatePet(Pet pet);
    @Delete("delete from pets where id=#{id}")
    int deleteById(int id);
}


