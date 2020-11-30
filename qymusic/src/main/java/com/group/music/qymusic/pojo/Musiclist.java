package com.group.music.qymusic.pojo;

import java.util.List;

public class Musiclist {
    private Integer id;

    private String name;

    private String img;

    private String introduce;

    private Integer clickvolume;

    private String type;



    public Musiclist() {
    }

    public Musiclist(Integer id, String name, String img, String introduce, Integer clickvolume, String type) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.introduce = introduce;
        this.clickvolume = clickvolume;
        this.type = type;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getClickvolume() {
        return clickvolume;
    }

    public void setClickvolume(Integer clickvolume) {
        this.clickvolume = clickvolume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}