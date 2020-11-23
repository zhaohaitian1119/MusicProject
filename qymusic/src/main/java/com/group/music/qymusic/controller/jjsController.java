package com.group.music.qymusic.controller;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.group.music.qymusic.pojo.*;
import com.group.music.qymusic.service.*;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.resources.cldr.ti.CalendarData_ti_ER;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class jjsController {
    @Resource
    MusicServicejjs musicServicejjs;
    @Resource
    MusiclistServicejjs musiclistServicejjs;
    @Resource
    User_infoServicejjs user_infoServicejjs;
    @Resource
    User_musicServicejjs user_musicServicejjs;
    @Resource
    Musiclist_infoServicejjs musiclist_infoServicejjs;

    //搜索音乐
    @ResponseBody
    @RequestMapping("/musicLink/getSongRearch")
    public Map<String, Object> getSongRearch(String songname) {
        Map<String, Object> map = new HashMap<>();
        List<Music> music = musicServicejjs.selectByName(songname);
        //循环打印music集合
        /*for (Music music1 : music) {
            System.out.println(music1.getName());
        }*/
        map.put("music", music);
        return map;
    }

    @ResponseBody
    @RequestMapping("/musicLink/addMusicCollect")
    public Map<String, Object> addMusicCollect(String songName, Integer song_id, String user_name, String user_password) {
        Map<String, Object> map = new HashMap<>();
        user_name = "忆往昔";
        //验证是否登录
        /*if (user_name == null || "".equals(user_name)) {
            map.put("statusCode", "1");
            return map;
        }*/
        User_info user_info = user_infoServicejjs.selectByuserName(user_name);
        //得到用戶id
        Integer userId = user_info.getUserId();

        List<User_music> user_musics = user_musicServicejjs.selectByuserId(userId);

        List<Musiclist> musiclists = musiclistServicejjs.selectByType("0");

        for (int i = 0; i < musiclists.size(); i++) {
            for (User_music user_music : user_musics) {
                if (musiclists.get(i).getId() == user_music.getMusiclistId()) {
                    int count = musiclist_infoServicejjs.count(song_id, musiclists.get(i).getId());
                    if (count > 0) {
                        map.put("statusCode", "201");
                        return map;
                    }
                    int insert = musiclist_infoServicejjs.insert(new Musiclist_info(null, musiclists.get(i).getId(),song_id));
                    if (insert > 0) {
                        map.put("statusCode", "200");
                        return map;
                    }
                }
            }


        }
        /*int insert = musiclistServicejjs.insert(new Musiclist(null, "我喜欢的", "/static/images/图片/我喜欢的.jpg", "收藏你喜欢的音乐", 0, "0"));
        if (insert > 0) {

        }*/
        return map;
    }
}
