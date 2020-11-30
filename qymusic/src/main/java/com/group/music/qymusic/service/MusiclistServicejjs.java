package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.Musiclist;

import java.util.List;

public interface MusiclistServicejjs {
    int insert(Musiclist musiclist);

    List<Musiclist> selectByType(String type);


}
