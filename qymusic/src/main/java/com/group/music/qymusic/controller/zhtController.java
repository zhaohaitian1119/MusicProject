package com.group.music.qymusic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.pojo.Comment;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.pojo.User_info;
import com.group.music.qymusic.service.MusicServicezht;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-23 14:52
 */
@Controller
public class zhtController {

    @Resource
    MusicServicezht musicServicezht;

    @RequestMapping("qingyu")
    public String qyMusciList(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("clickvolume desc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu1")
    public String qyMusciList1(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("clickvolume desc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu2")
    public String qyMusciList2(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("clickvolume asc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu3")
    public String qyMusciList3(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("id asc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu4")
    public String qyMusciList4(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("id desc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu5")
    public String qyMusciList5(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("name asc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu6")
    public String qyMusciList6(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("name desc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu7")
    public String qyMusciList7(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("singer_id desc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu8")
    public String qyMusciList8(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("singer_id asc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu9")
    public String qyMusciList9(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("duration desc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("qingyu10")
    public String qyMusciList10(Model model) {
        PageHelper.startPage(0, 30);
        PageHelper.orderBy("duration asc");
        PageInfo<Music> musicPageInfo = musicServicezht.qyMusciList();
        model.addAttribute("musicPageInfo", musicPageInfo);
        return "bangdan";
    }

    @RequestMapping("singerxq")
    public String singer1(Model model, Integer singerid) {
        Singer singer = musicServicezht.selbyIdSinger(singerid);
        PageHelper.startPage(0, 10);
        PageHelper.orderBy("clickvolume desc");
        PageInfo<Music> musicPageInfo = musicServicezht.selBySinger_id(singerid);
        model.addAttribute("musicPageInfo", musicPageInfo);
        model.addAttribute("singer", singer);
        return "singerxq";
    }

    @RequestMapping("musicxq")
    public String musicxq(Model model, Integer id) {
        Music music = musicServicezht.selById(id);
        String lyric = music.getLyric();
        String[] split = lyric.split(",");
        List<String> strings = new ArrayList<>();
        for (Integer i = 0; i < split.length; i++) {
            strings.add(split[i]);
        }
        List<Comment> comments = musicServicezht.selByMusic_id(id);
        for (Comment comment : comments) {
            if (comment.getUserId() != null) {
                List<User_info> user_infos = musicServicezht.selByUser_id(comment.getUserId());
                if (user_infos.size() != 0) {
                    comment.setUser_info(user_infos.get(0));
                }
            }
        }
        Integer sum = comments.size();
        model.addAttribute("musicxq", music);
        model.addAttribute("strings", strings);
        model.addAttribute("comments", comments);
        model.addAttribute("sum", sum);
        return "musicxq";
    }

    //发表评论

    @RequestMapping("/fbpl")
    @ResponseBody
    public boolean fbpl(Comment comment) {
        comment.setCommenttime(new Date());
        comment.setGoods(0);
        int a = musicServicezht.inserMusicComment(comment);
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }


}
