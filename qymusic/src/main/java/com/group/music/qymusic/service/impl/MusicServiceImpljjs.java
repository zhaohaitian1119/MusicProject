package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.MusicMapper;
import com.group.music.qymusic.mapper.SingerMapper;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.MusicExample;
import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.service.MusicServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MusicServiceImpljjs implements MusicServicejjs {
    @Resource
    MusicMapper musicMapper;
    @Resource
    SingerMapper singerMapper;

    @Override
    public List<Music> selectByName(String lll) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        if (lll != null) {
            criteria.andNameLike("%" + lll + "%");
        }
        List<Music> music = musicMapper.selectByExample(example);
        for (Music music1 : music) {
            if (music1.getSingerId() != null) {
                Singer singer = singerMapper.selectByPrimaryKey(music1.getSingerId());
                music1.setSingername(singer.getName());
            }


        }
        return music;
    }
}
