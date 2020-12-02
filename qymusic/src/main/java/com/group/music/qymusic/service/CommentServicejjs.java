package com.group.music.qymusic.service;

import com.group.music.qymusic.pojo.Comment;

import java.util.List;

public interface CommentServicejjs {
    List<Comment> selectByMusicListId(Integer musicListId);

    int insert(Comment comment);

    Comment selectById(Integer id);

    int updGoods(Comment comment);
}
