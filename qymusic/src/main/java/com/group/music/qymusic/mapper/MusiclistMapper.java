package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.pojo.MusiclistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusiclistMapper {
    int countByExample(MusiclistExample example);

    int deleteByExample(MusiclistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Musiclist record);

    int insertSelective(Musiclist record);

    List<Musiclist> selectByExample(MusiclistExample example);

    Musiclist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Musiclist record, @Param("example") MusiclistExample example);

    int updateByExample(@Param("record") Musiclist record, @Param("example") MusiclistExample example);

    int updateByPrimaryKeySelective(Musiclist record);

    int updateByPrimaryKey(Musiclist record);
}