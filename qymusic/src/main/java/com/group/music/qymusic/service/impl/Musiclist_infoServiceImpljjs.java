package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.controller.jjsController;
import com.group.music.qymusic.mapper.Musiclist_infoMapper;
import com.group.music.qymusic.mapper.SingerMapper;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.Musiclist_info;
import com.group.music.qymusic.pojo.Musiclist_infoExample;
import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.service.Musiclist_infoServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Musiclist_infoServiceImpljjs implements Musiclist_infoServicejjs {
    @Resource
    Musiclist_infoMapper musiclist_infoMapper;
    @Resource
    SingerMapper singerMapper;

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

    @Override
    public List<Musiclist_info> selectByMusicListId(Integer musicListId) {
        List<Musiclist_info> musiclist_infos = musiclist_infoMapper.selectByMusicListid(musicListId);
        for (Musiclist_info musiclist_info : musiclist_infos) {
            for (Music music : musiclist_info.getMusics()) {
                Singer singer = singerMapper.selectByPrimaryKey(music.getSingerId());
                music.setSingername(singer.getName());
            }
        }

        return musiclist_infos;
    }

    @Override
    public void del(Integer id) {
        musiclist_infoMapper.deleteByPrimaryKey(id);
    }
}
