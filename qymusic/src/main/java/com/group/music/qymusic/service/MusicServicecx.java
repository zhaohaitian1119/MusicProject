package com.group.music.qymusic.service;

import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.pojo.Music;

public interface MusicServicecx {
    PageInfo<Music> selectMusic(int pageIndex, int pageSize);
}
