package com.group.music.qymusic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.mapper.CommentMapper;
import com.group.music.qymusic.mapper.MusicMapper;
import com.group.music.qymusic.mapper.SingerMapper;
import com.group.music.qymusic.mapper.User_infoMapper;
import com.group.music.qymusic.pojo.*;
import com.group.music.qymusic.service.MusicServicezht;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-23 15:08
 */
@Service
public class MusicServiceImplzht implements MusicServicezht{

    @Resource
    MusicMapper musicMapper;
    @Resource
    SingerMapper singerMapper;
    @Resource
    CommentMapper commentMapper;
    @Resource
    User_infoMapper user_infoMapper;

    //轻语音乐榜
    @Override
    public PageInfo<Music> qyMusciList() {
        List<Music> music = musicMapper.selectByExample(null);

        for (Music music1 : music){
            if(music1.getSingerId()!=null){
                List<Singer> singers = singerAll(music1.getSingerId());
                if(singers.size()>0){
                    music1.setSingername(singers.get(0).getName());
                }
            }
        }

        PageInfo<Music> musicPageInfo = new PageInfo<>(music);
        return musicPageInfo;
    }

    @Override
    public List<Singer> singerAll(Integer id) {
        SingerExample example = new SingerExample();
        SingerExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Singer> singers = singerMapper.selectByExample(example);
        return singers;
    }

    @Override
    public Singer selbyIdSinger(Integer id) {
        Singer singer = singerMapper.selectByPrimaryKey(id);
        return singer;
    }

    @Override
    public PageInfo<Music> selBySinger_id(Integer singerid) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        criteria.andSingerIdEqualTo(singerid);
        List<Music> music = musicMapper.selectByExample(example);
        PageInfo<Music> musicPageInfo = new PageInfo<>(music);
        return musicPageInfo;
    }

    @Override
    public Music selById(Integer id) {
        Music music = musicMapper.selectByPrimaryKey(id);
        if(music.getSingerId()!=null){
            List<Singer> singers = singerAll(music.getSingerId());
            if(singers.size()>0){
                music.setSingername(singers.get(0).getName());
            }
        }
        return music;
    }

    @Override
    public List<Comment> selByMusic_id(Integer musicid) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andMusicIdEqualTo(musicid);
        List<Comment> comments = commentMapper.selectByExample(example);
        return comments;
    }

    @Override
    public List<User_info> selByUser_id(Integer userid) {
        User_infoExample example = new User_infoExample();
        User_infoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<User_info> user_infos = user_infoMapper.selectByExample(example);
        return user_infos;
    }

    @Override
    public int inserMusicComment(Comment comment) {
        int i = commentMapper.insertSelective(comment);
        return i;
    }
}
