package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.Musiclist;

import java.util.List;

public interface MusiclistServicecx {

    int addMusiclist(Musiclist musiclist);
    List<Musiclist> selectMusiclist();
}
