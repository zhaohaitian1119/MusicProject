package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.MusiclistMapper;
import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.service.MusiclistServicecx;

import javax.annotation.Resource;
import java.util.List;

public class MusiclistServicecxImpl implements MusiclistServicecx {
    @Resource
    MusiclistMapper musiclistMapper;

    @Override
    public int addMusiclist(Musiclist musiclist) {
        return musiclistMapper.insert(musiclist);
    }

    @Override
    public List<Musiclist> selectMusiclist() {
        return musiclistMapper.selectByExample(null);
    }
}
