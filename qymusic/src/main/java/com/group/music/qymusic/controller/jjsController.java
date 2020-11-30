package com.group.music.qymusic.controller;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.group.music.qymusic.pojo.*;
import com.group.music.qymusic.service.*;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.resources.cldr.ti.CalendarData_ti_ER;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
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

    public Integer selMudicList(Integer userId, String type) {
        List<User_music> user_musics = user_musicServicejjs.selectByuserId(userId);
        List<Musiclist> musiclists = musiclistServicejjs.selectByType(type);
        for (int i = 0; i < musiclists.size(); i++) {
            for (User_music user_music : user_musics) {
                if (musiclists.get(i).getId() == user_music.getMusiclistId()) {
                    return musiclists.get(i).getId();
                }
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/musicLink/addMusicCollect")
    public Map<String, Object> addMusicCollect(String songName, Integer song_id, String user_name, String user_password, HttpSession session) {
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
                    session.setAttribute("musiclistId", musiclists.get(i).getId());
                    int count = musiclist_infoServicejjs.count(song_id, musiclists.get(i).getId());
                    if (count > 0) {
                        map.put("statusCode", "201");
                        return map;
                    }
                    int insert = musiclist_infoServicejjs.insert(new Musiclist_info(null, musiclists.get(i).getId(), song_id));
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

  /*  @ResponseBody
    @RequestMapping("/myMusic/getMyMusicList")
    public Map<String, Object> getMyMusicList(Integer song_id, String user_name, String user_password, HttpSession session) {
        System.out.println("11111111111111");
        Map<String, Object> map = new HashMap<>();
        user_name = "忆往昔";
        //验证是否登录
        *//*if (user_name == null || "".equals(user_name)) {
            map.put("statusCode", "1");
            return map;
        }*//*
        Integer musiclistId = (Integer) session.getAttribute("musiclistId");
        System.out.println(musiclistId);
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musiclistId);
        if (musiclist_infos == null || musiclist_infos.size() == 0) {
            map.put("statusCode", "202");
            return map;
        } else {
            map.put("statusCode", "200");
            map.put("list", musiclist_infos);
            return map;
        }*/

    @RequestMapping("/myMusic/getMyMusicList")
    public String getMyMusicList(Integer song_id, HttpSession
            session, Model model) {
        //验证是否登录
        /*if (user_name == null || "".equals(user_name)) {
            map.put("statusCode", "1");
            return map;
        }*/
        Integer musiclistId = selMudicList(1, "0");
        System.out.println(musiclistId);
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musiclistId);
        Music music = musicServicejjs.selectById(song_id);
        model.addAttribute("music", music);
        if (musiclist_infos == null || musiclist_infos.size() == 0) {
            model.addAttribute("error", "您还没有收藏歌曲哦，快去列表收藏吧！");
            return "QQmusic";
        } else {
            model.addAttribute("musiclist_infos", musiclist_infos);
            return "QQmusic";
        }
    }


    @RequestMapping("/selMusic")
    public String selMusic(Integer id, Model model) {
        Music music = musicServicejjs.selectById(id);
        model.addAttribute("music", music);
        return "QQmusic";
    }

    @RequestMapping("/del")
    public String del(Integer id, Integer song_id, Model model) {
        musiclist_infoServicejjs.del(id);
        //获取session作用域中的用户Id
        Integer musiclistId = selMudicList(1, "0");
        System.out.println(musiclistId);
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musiclistId);
        Music music = musicServicejjs.selectById(song_id);
        model.addAttribute("music", music);
        if (musiclist_infos == null || musiclist_infos.size() == 0) {
            model.addAttribute("error", "您还没有收藏歌曲哦，快去列表收藏吧！");
            return "QQmusic";
        } else {
            model.addAttribute("musiclist_infos", musiclist_infos);
            return "QQmusic";
        }
    }

    @ResponseBody
    @RequestMapping("/down.do")
    public void fileDownload(HttpServletResponse response, HttpServletRequest request, String filename) {
        //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
//        String realPath = "D:/workspace_idea2/MusicProject/qymusic/src/main/resources/static";//获取下载文件的路径

        String realPath = null;
        try {
            realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/music/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File(realPath, filename);
        //设置响应类型  ==》 告诉浏览器当前是下载操作，我要下载东西
        response.setContentType("application/x-msdownload");
        //设置下载时文件的显示类型(即文件名称-后缀)   ex：txt为文本类型
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(filename, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(filename);
        //下载文件：将一个路径下的文件数据转到一个输出流中，也就是把服务器文件通过流写(复制)到浏览器端
        try {
            Files.copy(file.toPath(), response.getOutputStream());//Files.copy(要下载的文件的路径,响应的输出流)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/myMusic/next")
    public String music_next(Integer song_id, HttpSession session, Model model) {
        //获取session作用域中的用户Id
        Integer musiclistId = selMudicList(1, "0");
        System.out.println(musiclistId);
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musiclistId);
        model.addAttribute("musiclist_infos", musiclist_infos);
        for (int i = 0; i < musiclist_infos.size(); i++) {
            if (musiclist_infos.get(i).getMusicId() == song_id) {
                if (i == musiclist_infos.size() - 1) {
                    Music music = musicServicejjs.selectById(musiclist_infos.get(0).getMusicId());
                    model.addAttribute("music", music);
                    return "QQmusic";
                } else {
                    Music music = musicServicejjs.selectById(musiclist_infos.get(i + 1).getMusicId());
                    model.addAttribute("music", music);
                    return "QQmusic";
                }
            } else {
                Music music = musicServicejjs.selectById(musiclist_infos.get(0).getMusicId());
                model.addAttribute("music", music);
                return "QQmusic";
            }
        }
        return "QQmusic";
    }

    @RequestMapping("/myMusic/pre")
    public String music_pre(Integer song_id, HttpSession session, Model model) {
        //获取session作用域中的用户Id
        Integer musiclistId = selMudicList(1, "0");
        System.out.println(musiclistId);
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musiclistId);
        model.addAttribute("musiclist_infos", musiclist_infos);
        for (int i = 0; i < musiclist_infos.size(); i++) {
            if (musiclist_infos.get(i).getMusicId() == song_id) {
                if (i == 0) {
                    Music music = musicServicejjs.selectById(musiclist_infos.get(musiclist_infos.size() - 1).getMusicId());
                    model.addAttribute("music", music);
                    return "QQmusic";
                } else {
                    Music music = musicServicejjs.selectById(musiclist_infos.get(i - 1).getMusicId());
                    model.addAttribute("music", music);
                    return "QQmusic";
                }
            } else {
                Music music = musicServicejjs.selectById(musiclist_infos.get(0).getMusicId());
                model.addAttribute("music", music);
                return "QQmusic";
            }
        }
        return "QQmusic";
    }
}
