package com.group.music.qymusic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.mapper.MusicMapper;
import com.group.music.qymusic.mapper.SingerMapper;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.service.MusicServicecx;
import com.group.music.qymusic.service.SingerServicecx;

import javax.annotation.Resource;
import java.util.List;

public class MusicServicecxImpl implements MusicServicecx {
    @Resource
    MusicMapper musicMapper;
    @Resource
    SingerServicecx singerServicecx;

    @Override
    public PageInfo<Music> selectMusic(int pageIndex, int pageSize) {
        PageHelper.orderBy("id asc");
        PageHelper.startPage(pageIndex,pageSize);
        List<Music> music = musicMapper.selectByExample(null);
        PageInfo pageInfo=new PageInfo(music);
        for(Music music2:music){
            if(music2.getSingerId()!=null){
                List<Singer> singers = singerServicecx.selectSinger(music2.getSingerId());
                music2.setSingername(singers.get(0).getName());
            }
        }
        return pageInfo;
    }
}
