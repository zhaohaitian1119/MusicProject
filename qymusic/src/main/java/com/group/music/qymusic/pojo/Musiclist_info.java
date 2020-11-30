package com.group.music.qymusic.pojo;

import java.util.List;

public class Musiclist_info {
    private Integer id;

    private Integer musiclistId;

    private Integer musicId;
    
    private List<Music> musics;

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMusiclistId() {
        return musiclistId;
    }

    public void setMusiclistId(Integer musiclistId) {
        this.musiclistId = musiclistId;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public Musiclist_info() {
    }

    public Musiclist_info(Integer id, Integer musiclistId, Integer musicId) {
        this.id = id;
        this.musiclistId = musiclistId;
        this.musicId = musicId;
    }
}