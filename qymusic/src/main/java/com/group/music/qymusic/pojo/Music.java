package com.group.music.qymusic.pojo;

public class Music {
    private Integer id;

    private String name;

    private String address;

    private Integer singerId;

    private Integer slbumUd;

    private Integer clickvolume;

    private String lyric;

    private String musicpic;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public Integer getSlbumUd() {
        return slbumUd;
    }

    public void setSlbumUd(Integer slbumUd) {
        this.slbumUd = slbumUd;
    }

    public Integer getClickvolume() {
        return clickvolume;
    }

    public void setClickvolume(Integer clickvolume) {
        this.clickvolume = clickvolume;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric == null ? null : lyric.trim();
    }

    public String getMusicpic() {
        return musicpic;
    }

    public void setMusicpic(String musicpic) {
        this.musicpic = musicpic == null ? null : musicpic.trim();
    }
}