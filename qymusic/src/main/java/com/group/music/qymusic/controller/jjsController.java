package com.group.music.qymusic.controller;

import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.service.MusicServicejjs;
import com.group.music.qymusic.service.MusiclistServicejjs;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        //验证是否登录
        /*if (user_name == null || "".equals(user_name)) {
            map.put("statusCode", "1");
            return map;
        }*/
        
        int insert = musiclistServicejjs.insert(new Musiclist(null, "我喜欢的", "/static/images/图片/我喜欢的.jpg", "收藏你喜欢的音乐", 0, "0"));
        if (insert > 0) {
            map.put("statusCode", "200");
            return map;
        }
        return map;
    }
}
