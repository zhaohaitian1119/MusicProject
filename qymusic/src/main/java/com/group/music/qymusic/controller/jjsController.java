package com.group.music.qymusic.controller;

import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.service.MusicServicejjs;
import org.springframework.stereotype.Controller;
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

    //搜索音乐
    @ResponseBody
    @RequestMapping("/musicLink/getSongRearch")
    public Map<String, Object> getSongRearch(String songname) {
        Map<String, Object> map = new HashMap<>();
        List<Music> music = musicServicejjs.selectByName(songname);
        for (Music music1 : music) {
            System.out.println(music1.getName());
        }
        map.put("music", music);
        return map;
    }
}
