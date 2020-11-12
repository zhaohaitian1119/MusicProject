package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.Musicrtype;
import com.group.music.qymusic.pojo.MusicrtypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicrtypeMapper {
    int countByExample(MusicrtypeExample example);

    int deleteByExample(MusicrtypeExample example);

    int insert(Musicrtype record);

    int insertSelective(Musicrtype record);

    List<Musicrtype> selectByExample(MusicrtypeExample example);

    int updateByExampleSelective(@Param("record") Musicrtype record, @Param("example") MusicrtypeExample example);

    int updateByExample(@Param("record") Musicrtype record, @Param("example") MusicrtypeExample example);
}