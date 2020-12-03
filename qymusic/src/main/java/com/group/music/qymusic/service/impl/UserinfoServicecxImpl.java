package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.User_infoMapper;
import com.group.music.qymusic.pojo.User_info;
import com.group.music.qymusic.pojo.User_infoExample;
import com.group.music.qymusic.service.UserinfoServicecx;

import javax.annotation.Resource;
import java.util.List;

public class UserinfoServicecxImpl implements UserinfoServicecx {
    @Resource
    User_infoMapper user_infoMapper;

    @Override
    public int addUserinfo(User_info user_info) {
        return user_infoMapper.insert(user_info);
    }

    @Override
    public User_info selectUserinfo(int userId) {
        User_info user_info=null;
        User_infoExample user_infoExample=new User_infoExample();
        User_infoExample.Criteria criteria = user_infoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<User_info> userInfoList=user_infoMapper.selectByExample(user_infoExample);
        if(userInfoList.size()>0){
            user_info=userInfoList.get(0);
        }
        return user_info;
    }

    @Override
    public int updUserinfo(User_info user_info, int userId) {
        User_infoExample user_infoExample=new User_infoExample();
        User_infoExample.Criteria criteria = user_infoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return user_infoMapper.updateByExampleSelective(user_info,user_infoExample);
    }

}
