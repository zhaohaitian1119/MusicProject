package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.CommentMapper;
import com.group.music.qymusic.mapper.UserMapper;
import com.group.music.qymusic.mapper.User_infoMapper;
import com.group.music.qymusic.pojo.*;
import com.group.music.qymusic.service.CommentServicejjs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpljjs implements CommentServicejjs {
    @Resource
    CommentMapper commentMapper;
    @Resource
    User_infoMapper user_infoMapper;

    @Override
    public List<Comment> selectByMusicListId(Integer musicListId) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andMusiclistIdEqualTo(musicListId);
        List<Comment> comments = commentMapper.selectByExample(example);
        for (Comment comment : comments) {
            User_infoExample example1 = new User_infoExample();
            example1.createCriteria().andUserIdEqualTo(comment.getUserId());
            List<User_info> user_infos = user_infoMapper.selectByExample(example1);
            if (user_infos.size() > 0) {
                comment.setUser_info(user_infos.get(0));
            }
        }
        return comments;
    }

    @Override
    public int insert(Comment comment) {
        int insert = commentMapper.insert(comment);
        return insert;
    }

    @Override
    public Comment selectById(Integer id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        return comment;
    }

    @Override
    public int updGoods(Comment comment) {
        int i = commentMapper.updateByPrimaryKeySelective(comment);
        return i;
    }
}
