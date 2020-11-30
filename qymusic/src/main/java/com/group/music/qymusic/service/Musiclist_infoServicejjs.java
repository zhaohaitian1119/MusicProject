package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.Musiclist_info;

import java.util.List;

public interface Musiclist_infoServicejjs {
    int insert(Musiclist_info musiclist_info);

    int count(Integer musicId, Integer musiclistId);

    List<Musiclist_info> selectByMusicListId(Integer MusicListId);

    void del(Integer id);
}
