package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.User_musicMapper;
import com.group.music.qymusic.pojo.User_music;
import com.group.music.qymusic.service.UsermusicServicecx;

import javax.annotation.Resource;

public class UsermusicServicecxImpl implements UsermusicServicecx {
    @Resource
    User_musicMapper user_musicMapper;

    @Override
    public int addUsermusic(User_music user_music) {
        return user_musicMapper.insert(user_music);
    }
}
