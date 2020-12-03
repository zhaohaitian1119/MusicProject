package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.User;

public interface LoginServicecx {
    //注册
    int add(User user);
    //根据手机查询
    User getById(String phone);
    //登录
    User login(String phone);
    //修改密码
    int updPassword(User user);

}
