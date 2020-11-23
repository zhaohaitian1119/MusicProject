package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.Musiclist_info;

public interface Musiclist_infoServicejjs {
    int insert(Musiclist_info musiclist_info);

    int count(Integer musicId, Integer musiclistId);
}
