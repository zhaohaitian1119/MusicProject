package com.group.music.qymusic.service;

import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.pojo.Musiclist_info;

public interface MusiclistInfoServicecx {
    PageInfo<Musiclist_info> selectLike(int pageNum, int pageSize, int musiclistid);
}
