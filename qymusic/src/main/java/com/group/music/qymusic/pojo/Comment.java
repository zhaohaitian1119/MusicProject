package com.group.music.qymusic.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer userId;

    private Integer musicId;

    private String messige;

    private Date commenttime;

    private Integer parentId;

    private Integer musiclistId;

    private Integer goods;

    private User_info user_info;

    public User_info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_info user_info) {
        this.user_info = user_info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMessige() {
        return messige;
    }

    public void setMessige(String messige) {
        this.messige = messige == null ? null : messige.trim();
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMusiclistId() {
        return musiclistId;
    }

    public void setMusiclistId(Integer musiclistId) {
        this.musiclistId = musiclistId;
    }

    public Integer getGoods() {
        return goods;
    }

    public void setGoods(Integer goods) {
        this.goods = goods;
    }
}