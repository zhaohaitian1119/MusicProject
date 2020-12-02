package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.MusicMapper;
import com.group.music.qymusic.mapper.SingerMapper;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.MusicExample;
import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.service.MusicServicejjs;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.geometry.Orientation;
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

        if (lll != null) {
            MusicExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%" + lll + "%");
            example.or(criteria);
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

    @Override
    public Music selectById(Integer id) {
        Music music = musicMapper.selectByPrimaryKey(id);
        if (music.getSingerId() != null) {
            Singer singer = singerMapper.selectByPrimaryKey(music.getSingerId());
            music.setSingername(singer.getName());
        }
        return music;
    }
}
