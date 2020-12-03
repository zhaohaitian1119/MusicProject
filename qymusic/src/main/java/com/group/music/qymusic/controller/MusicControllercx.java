package com.group.music.qymusic.controller;

import com.github.pagehelper.PageInfo;
import com.group.music.qymusic.pojo.Music;
import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.pojo.Musiclist_info;
import com.group.music.qymusic.service.MusicServicecx;
import com.group.music.qymusic.service.MusiclistInfoServicecx;
import com.group.music.qymusic.service.MusiclistServicecx;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MusicControllercx {
    @Resource
    MusicServicecx musicServicecx;
    @Resource
    MusiclistServicecx musiclistServicecx;
    @Resource
    MusiclistInfoServicecx musiclistInfoServicecx;

    @RequestMapping("/selectMusic")
    public String selectMusic(HttpServletRequest request, Model model){
        int Num=1;
        String pageNum=request.getParameter("pageNum");
        if(pageNum!=null){
            Num=Integer.parseInt(pageNum);
        }
        int pageSize=10;
        PageInfo<Music> musicPageInfo = musicServicecx.selectMusic(Num, pageSize);
        model.addAttribute("musicPageInfo",musicPageInfo);
        return "mymusic";
    }

    @RequestMapping("/addMusiclist")
    public String addMusiclist(Musiclist musiclist,String name){
        musiclist.setName(name);
        musiclist.setImg("/images/2.jpg");
        musiclist.setIntroduce("这个人很懒,什么都没留下");
        musiclist.setClickvolume(0);
        musiclist.setType("0");
        musiclistServicecx.addMusiclist(musiclist);
        return "redirect:/selectMusiclist";
    }

    @RequestMapping("/selectMusiclist")
    public String selectMusiclist(Model model) {
        List<Musiclist> musiclists = musiclistServicecx.selectMusiclist();
        model.addAttribute("musiclists",musiclists);
        return "mymusiclist";
    }

    @RequestMapping("/selectLike")
    public String selectLike(Model model,HttpServletRequest request){
        int Num=1;
        String pageNum=request.getParameter("pageNum");
        if(pageNum!=null){
            Num=Integer.parseInt(pageNum);
        }
        int pageSize=10;
        PageInfo<Musiclist_info> musiclist_infoPageInfo = musiclistInfoServicecx.selectLike(Num, pageSize, 2);
        model.addAttribute("musicPageInfo",musiclist_infoPageInfo);
        return "mymusic";
    }


    @RequestMapping("/zhuxiao")
    public String zhuxiao(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
