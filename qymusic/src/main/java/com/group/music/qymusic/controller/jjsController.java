package com.group.music.qymusic.controller;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.group.music.qymusic.pojo.*;
import com.group.music.qymusic.service.*;
import com.sun.org.apache.bcel.internal.generic.IMPDEP1;
import javafx.scene.control.Alert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.ti.CalendarData_ti_ER;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

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

    @Resource
    CommentServicejjs commentServicejjs;

    @RequestMapping("")
    public String toIndex(@RequestParam(value = "type", required = false, defaultValue = "") String type,
                          @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, Model model) {
        Integer pageSize = 10;
        List<Musiclist> musiclists = musiclistServicejjs.selectByTypeAndClick(type, pageSize, pageNum);
        if (musiclists.size() > 0) {
            model.addAttribute("musiclists", musiclists);
        }
        return "index";
    }


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

//    @RequestMapping("/selByMusicName")
//    public String selByMusicName(String songName, Model model) {
//        List<Music> musiclist_infos = musicServicejjs.selectByName(songName);
//        model.addAttribute("musiclist_infos", musiclist_infos);
//        return "MusicListInfo";
//    }

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
    public Map<String, Object> addMusicCollect(Integer song_id, HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //验证是否登录
        /*if (user_name == null || "".equals(user_name)) {
            map.put("statusCode", "1");
            return map;
        }*/
        Integer userId = 1;
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

    //播放单个音乐的控制器
    @RequestMapping("/selMusic")
    public String selMusic(Integer id, Model model) {
        Music music = musicServicejjs.selectById(id);
        model.addAttribute("music", music);
        System.out.println(music.getName());
        return "QQmusic";
    }

    //删除用户我喜欢的音乐
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

    //下载音乐
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

    //切换下首歌
    @RequestMapping("/myMusic/next")
    public String music_next(Integer song_id, Integer musicListId, HttpSession session, Model model) {
        //获取session作用域中的用户Id
//        Integer musiclistId = selMudicList(1, "0");
//        System.out.println(musiclistId);
        if (musicListId == null) {
            Music music = musicServicejjs.selectById(song_id);
            model.addAttribute("music", music);
            System.out.println(music.getName());
            return "QQmusic";
        }
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musicListId);
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
            }
        }

        Music music = musicServicejjs.selectById(musiclist_infos.get(0).getMusicId());
        model.addAttribute("music", music);
        return "QQmusic";
    }

    //切换上首歌
    @RequestMapping("/myMusic/pre")
    public String music_pre(Integer song_id, Integer musicListId, HttpSession session, Model model) {
        if (musicListId == null) {
            Music music = musicServicejjs.selectById(song_id);
            model.addAttribute("music", music);
            System.out.println(music.getName());
            return "QQmusic";
        }
        //获取session作用域中的用户Id
     /*   Integer musiclistId = selMudicList(1, "0");
        System.out.println(musiclistId);*/
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musicListId);
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
            }

        }
        Music music = musicServicejjs.selectById(musiclist_infos.get(0).getMusicId());
        model.addAttribute("music", music);
        return "QQmusic";
    }

    //根据歌单id展示歌单中的音乐
    @RequestMapping("/selMusicList")
    public String selMusicList(Integer musicListId, Model model) {
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musicListId);
        model.addAttribute("musiclist_infos", musiclist_infos);
        return "MusicListInfo";
    }

    //歌单详情页面相关信息控制器
    @RequestMapping("/selMusicList/getMusic")
    public String selMusicListAndGetMusic(Integer musicListId, Model model) {
        Musiclist musiclist = musiclistServicejjs.selectById(musicListId);
        model.addAttribute("musiclist", musiclist);
        List<Musiclist_info> musiclist_infos = musiclist_infoServicejjs.selectByMusicListId(musicListId);
        if (musiclist_infos.size() == 0) {
            musiclist_infos = null;
        }
        model.addAttribute("musiclist_infos", musiclist_infos);
        List<Comment> comments = commentServicejjs.selectByMusicListId(musicListId);
        model.addAttribute("count", comments.size());
        model.addAttribute("comments", comments);

        return "songlistxq";
    }

    //用户收藏歌单控制器
    @ResponseBody
    @RequestMapping("/getUser/addmusiclist")
    public Map<String, Object> addUserMusiclist(Integer musiclistId, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        //获取用户Id
        int i = user_musicServicejjs.selectByuserIdAndMusicListId(1, musiclistId);
        if (i > 0) {
            map.put("success", "0");//此用户以收藏此歌单
            return map;
        }
        int add = user_musicServicejjs.add(1, musiclistId);
        if (add > 0) {
            map.put("success", "1");//收藏成功
            return map;
        } else {
            map.put("success", "3");//添加失败
            return map;
        }
    }

    //增加评论
    @ResponseBody
    @RequestMapping("/CommentADD")
    public Map<String, Object> commentADD(Integer musiclistId, String message, HttpSession session) {

        Map<String, Object> map = new HashMap<>();
        Comment comment = new Comment();
        comment.setUserId(1);
        comment.setCommenttime(new Date());
        comment.setMessige(message);
        comment.setMusiclistId(musiclistId);
        int insert = commentServicejjs.insert(comment);
        if (insert > 0) {
            map.put("success", "1");
            return map;
        } else {
            map.put("success", "2");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/updGoods")
    public Map<String, Object> updGoods(Integer id) {
        Map<String, Object> map = new HashMap<>();
        Comment comment = commentServicejjs.selectById(id);
        comment.setGoods(comment.getGoods() + 1);
        int i = commentServicejjs.updGoods(comment);
        if (i > 0) {
            map.put("success", "1");
            map.put("comment",comment);
            return map;
        } else {
            map.put("success", "2");
            return map;

        }
    }

}
