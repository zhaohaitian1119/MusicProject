package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.MusicMapper;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.MusicExample;
import com.group.music.qymusic.service.MusicServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MusicServiceImpljjs implements MusicServicejjs {
    @Resource
    MusicMapper musicMapper;

    @Override
    public List<Music> selectByName(String lll) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        if (lll != null) {
            criteria.andNameLike("%" + lll + "%");
        }
        List<Music> music = musicMapper.selectByExample(example);
        return music;
    }
}
