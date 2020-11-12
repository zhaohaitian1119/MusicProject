package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.User_music;
import com.group.music.qymusic.pojo.User_musicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_musicMapper {
    int countByExample(User_musicExample example);

    int deleteByExample(User_musicExample example);

    int insert(User_music record);

    int insertSelective(User_music record);

    List<User_music> selectByExample(User_musicExample example);

    int updateByExampleSelective(@Param("record") User_music record, @Param("example") User_musicExample example);

    int updateByExample(@Param("record") User_music record, @Param("example") User_musicExample example);
}