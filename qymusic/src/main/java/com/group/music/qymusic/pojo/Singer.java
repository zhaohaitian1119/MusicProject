package com.group.music.qymusic.pojo;

public class Singer {
    private Integer id;

    private String name;

    private String nationality;

    private String birthday;

    private String introduce;

    private String names;

    private String classify;

    private String coverimage;

    private String homeimage;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names == null ? null : names.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage == null ? null : coverimage.trim();
    }

    public String getHomeimage() {
        return homeimage;
    }

    public void setHomeimage(String homeimage) {
        this.homeimage = homeimage == null ? null : homeimage.trim();
    }
}