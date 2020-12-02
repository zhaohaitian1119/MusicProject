package com.group.music.qymusic.service;

import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.pojo.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-23 15:06
 */
public interface MusicServicezht {
    //轻语音乐榜
    PageInfo<Music> qyMusciList();
    //歌手
    List<Singer> singerAll(Integer id);
    //根据id查找歌手
    Singer selbyIdSinger(Integer id);
    //根据歌手id查找歌曲
    PageInfo<Music> selBySinger_id(Integer singerid);
    //根据id查找歌曲
    Music selById(Integer id);
    //根据歌曲id查询评论
    List<Comment> selByMusic_id(Integer musicid);
    //根据用户id查询名称和头像
    List<User_info> selByUser_id(Integer userid);
    //新增歌曲评论
    int inserMusicComment(Comment comment);
}
