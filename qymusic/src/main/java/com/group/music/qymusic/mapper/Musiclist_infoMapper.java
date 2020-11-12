package com.group.music.qymusic.mapper;

import com.group.music.qymusic.pojo.Musiclist_info;
import com.group.music.qymusic.pojo.Musiclist_infoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Musiclist_infoMapper {
    int countByExample(Musiclist_infoExample example);

    int deleteByExample(Musiclist_infoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Musiclist_info record);

    int insertSelective(Musiclist_info record);

    List<Musiclist_info> selectByExample(Musiclist_infoExample example);

    Musiclist_info selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Musiclist_info record, @Param("example") Musiclist_infoExample example);

    int updateByExample(@Param("record") Musiclist_info record, @Param("example") Musiclist_infoExample example);

    int updateByPrimaryKeySelective(Musiclist_info record);

    int updateByPrimaryKey(Musiclist_info record);
}