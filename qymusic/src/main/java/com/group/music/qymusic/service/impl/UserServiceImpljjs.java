package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.UserMapper;
import com.group.music.qymusic.pojo.User;
import com.group.music.qymusic.service.UserServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpljjs implements UserServicejjs {

    @Resource
    UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
