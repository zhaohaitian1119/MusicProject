package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.User_info;
import com.group.music.qymusic.pojo.User_infoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_infoMapper {
    int countByExample(User_infoExample example);

    int deleteByExample(User_infoExample example);

    int insert(User_info record);

    int insertSelective(User_info record);

    List<User_info> selectByExample(User_infoExample example);

    int updateByExampleSelective(@Param("record") User_info record, @Param("example") User_infoExample example);

    int updateByExample(@Param("record") User_info record, @Param("example") User_infoExample example);
}