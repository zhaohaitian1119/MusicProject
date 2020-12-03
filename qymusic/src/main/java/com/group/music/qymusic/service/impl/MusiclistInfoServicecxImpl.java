package com.group.music.qymusic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.mapper.Musiclist_infoMapper;
import com.group.music.qymusic.pojo.Musiclist_info;
import com.group.music.qymusic.pojo.Musiclist_infoExample;
import com.group.music.qymusic.service.MusiclistInfoServicecx;

import javax.annotation.Resource;
import java.util.List;

public class MusiclistInfoServicecxImpl implements MusiclistInfoServicecx {
    @Resource
    Musiclist_infoMapper musiclist_infoMapper;

    @Override
    public PageInfo<Musiclist_info> selectLike(int pageNum,int pageSize,int musiclistid) {
        PageHelper.startPage(pageNum,pageSize);
        Musiclist_infoExample musiclist_infoExample=new Musiclist_infoExample();
        Musiclist_infoExample.Criteria criteria = musiclist_infoExample.createCriteria();
        criteria.andMusiclistIdEqualTo(musiclistid);
        List<Musiclist_info> musiclist_infos = musiclist_infoMapper.selectByExample(musiclist_infoExample);
        PageInfo pageInfo=new PageInfo(musiclist_infos);
        return pageInfo;
    }
}
