package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.pojo.SingerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SingerMapper {
    int countByExample(SingerExample example);

    int deleteByExample(SingerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Singer record);

    int insertSelective(Singer record);

    List<Singer> selectByExample(SingerExample example);

    Singer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByExample(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);
}