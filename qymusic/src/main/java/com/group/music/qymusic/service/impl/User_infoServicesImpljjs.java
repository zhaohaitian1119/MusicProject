package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.User_infoMapper;
import com.group.music.qymusic.pojo.User_info;
import com.group.music.qymusic.pojo.User_infoExample;
import com.group.music.qymusic.service.User_infoServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class User_infoServicesImpljjs implements User_infoServicejjs {
    @Resource
    User_infoMapper user_infoMapper;

    @Override
    public User_info selectByuserName(String username) {
        User_info user_info = null;
        User_infoExample example = new User_infoExample();
        User_infoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User_info> user_infos = user_infoMapper.selectByExample(example);
        if (user_infos != null) {
            user_info = user_infos.get(0);
        }
        return user_info;
    }
}
