package com.group.music.qymusic.pojo;

import java.util.Date;
import java.util.List;

public class Singer {
    private Integer id;

    private String name;

    private String nationality;

    private Date birthday;

    private String introduce;
    /*private List<Music> musiclist;

    public List<Music> getMusiclist() {
        return musiclist;
    }

    public void setMusiclist(List<Music> musiclist) {
        this.musiclist = musiclist;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}