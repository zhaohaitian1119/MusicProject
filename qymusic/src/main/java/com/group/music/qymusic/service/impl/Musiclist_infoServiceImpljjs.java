package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.Musiclist_infoMapper;
import com.group.music.qymusic.pojo.Musiclist_info;
import com.group.music.qymusic.pojo.Musiclist_infoExample;
import com.group.music.qymusic.service.Musiclist_infoServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Musiclist_infoServiceImpljjs implements Musiclist_infoServicejjs {
    @Resource
    Musiclist_infoMapper musiclist_infoMapper;

    @Override
    public int insert(Musiclist_info musiclist_info) {
        int insert = musiclist_infoMapper.insert(musiclist_info);
        return insert;
    }

    @Override
    public int count(Integer musicId, Integer musiclistId) {
        Musiclist_infoExample example = new Musiclist_infoExample();
        Musiclist_infoExample.Criteria criteria = example.createCriteria();
        criteria.andMusicIdEqualTo(musicId);
        criteria.andMusiclistIdEqualTo(musiclistId);
        int i = musiclist_infoMapper.countByExample(example);
        return i;
    }
}
