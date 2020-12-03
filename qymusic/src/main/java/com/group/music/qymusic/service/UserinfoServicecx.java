package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.User_info;

public interface UserinfoServicecx {
    //添加用户信息
    int addUserinfo(User_info user_info);
    //根据userId查询
    User_info selectUserinfo(int userId);
    //修改个人信息
    int updUserinfo(User_info user_info, int userId);


}
