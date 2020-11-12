package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.Musictype;
import com.group.music.qymusic.pojo.MusictypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusictypeMapper {
    int countByExample(MusictypeExample example);

    int deleteByExample(MusictypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Musictype record);

    int insertSelective(Musictype record);

    List<Musictype> selectByExample(MusictypeExample example);

    Musictype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Musictype record, @Param("example") MusictypeExample example);

    int updateByExample(@Param("record") Musictype record, @Param("example") MusictypeExample example);

    int updateByPrimaryKeySelective(Musictype record);

    int updateByPrimaryKey(Musictype record);
}