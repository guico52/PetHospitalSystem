package com.guico.mapper;

import com.guico.pojo.PetOwner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetOwnerMapper {
    @Select("select * from owners where id = #{petOwnerId}")
    PetOwner selectPetOwnerByPetOwnerId(int PetOwnerId);

    @Select("select * from owners")
    List<PetOwner> selectAllPetOwners();

    @Insert("insert into owners(name,address,city,telephone) values(#{petOwnerName},#{petOwnerAddress},#{petOwnerCity},#{petOwnerTelNo})")
    int insertPetOwner(PetOwner petOwner);

    @Update("update owners set name=#{petOwnerName},address=#{petOwnerAddress},city=#{petOwnerCity},telephone=#{petOwnerTelNo} where id=#{petOwnerId}")
    int updatePetOwner(PetOwner petOwner);

    @Delete("delete from owners where id=#{petOwnerId}")
    int deletePetOwnerByPetOwnerId(int PetOwnerId);
}
