package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.UserMapper;
import com.group.music.qymusic.pojo.User;
import com.group.music.qymusic.pojo.UserExample;
import com.group.music.qymusic.service.LoginServicecx;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class LoginServicecxImpl implements LoginServicecx {
    @Resource
    UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getById(String phone) {
        User user=null;
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()>0){
            user=users.get(0);
        }
        return user;
    }

    @Override
    public User login(String phone) {
        User user=null;
        List<User> users=new ArrayList<>();
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        users=userMapper.selectByExample(userExample);
        if(users.size()>0){
            user=users.get(0);
        }
        return user;
    }

    @Override
    public int updPassword(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
