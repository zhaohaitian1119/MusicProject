package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.User_musicMapper;
import com.group.music.qymusic.pojo.User_music;
import com.group.music.qymusic.pojo.User_musicExample;
import com.group.music.qymusic.service.User_musicServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class User_musicServiceImpljjs implements User_musicServicejjs {
    @Resource
    User_musicMapper user_musicMapper;

    @Override
    public List<User_music> selectByuserId(Integer userid) {
        User_music user_music = null;
        User_musicExample example = new User_musicExample();
        User_musicExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<User_music> user_musics = user_musicMapper.selectByExample(example);
        return user_musics;
    }
}
