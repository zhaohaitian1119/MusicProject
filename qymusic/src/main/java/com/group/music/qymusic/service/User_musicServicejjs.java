package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.User_music;

import java.util.List;

public interface User_musicServicejjs {
    List<User_music> selectByuserId(Integer userid);

    int add(Integer userId, Integer musicListId);

    int selectByuserIdAndMusicListId(int userId, Integer musiclistId);
}
