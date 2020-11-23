package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.MusiclistMapper;
import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.pojo.MusiclistExample;
import com.group.music.qymusic.service.MusiclistServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import java.util.List;

@Service
public class MusiclistServiceImpljjs implements MusiclistServicejjs {
    @Resource
    MusiclistMapper musiclistMapper;

    @Override
    public int insert(Musiclist musiclist) {
        int insert = musiclistMapper.insert(musiclist);
        return insert;
    }

    @Override
    public List<Musiclist> selectByType(String type) {
        MusiclistExample example = new MusiclistExample();
        MusiclistExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        List<Musiclist> musiclists = musiclistMapper.selectByExample(example);
        return musiclists;
    }
}
