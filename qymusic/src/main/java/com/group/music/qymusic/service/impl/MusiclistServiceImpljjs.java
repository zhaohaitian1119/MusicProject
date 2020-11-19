package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.MusiclistMapper;
import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.service.MusiclistServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MusiclistServiceImpljjs implements MusiclistServicejjs {
    @Resource
    MusiclistMapper musiclistMapper;

    @Override
    public int insert(Musiclist musiclist) {
        int insert = musiclistMapper.insert(musiclist);
        return insert;
    }
}
