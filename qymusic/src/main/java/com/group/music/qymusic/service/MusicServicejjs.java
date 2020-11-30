package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.Music;

import java.util.List;

public interface MusicServicejjs {
    List<Music> selectByName(String lll);

    Music selectById(Integer id);
}
