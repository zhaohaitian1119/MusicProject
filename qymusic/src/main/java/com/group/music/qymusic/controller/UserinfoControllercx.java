package com.group.music.qymusic.controller;

import com.group.music.qymusic.pojo.User;
import com.group.music.qymusic.pojo.User_info;
import com.group.music.qymusic.service.UserinfoServicecx;
import org.apache.commons.io.FilenameUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.math.RandomUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserinfoControllercx {
    @Resource
    UserinfoServicecx userinfoServicecx;

    //回显用户信息
    @RequestMapping("/getUserinfo")
    public String getUserinfo(int userId, Model model){
        User_info userinfo = userinfoServicecx.selectUserinfo(userId);
        model.addAttribute("userinfo",userinfo);
        return "updUserinfo";
    }

    //修改用户信息
    @RequestMapping("/updUserinfo")
    public String updUserinfo(User_info user_info, @RequestParam("userId") int userId, String username, String gender, String introduce,
                              Date birthday,String region){
        user_info.setUserId(userId);
        user_info.setUsername(username);
        user_info.setGender(gender);
        user_info.setIntroduce(introduce);
        user_info.setRegion(region);
        user_info.setBirthday(birthday);
        userinfoServicecx.updUserinfo(user_info,userId);
        return "redirect:/";
    }


    //修改头像
    @RequestMapping("/updImg")
    public String updatePath(MultipartFile file, int userId, Model model, User_info user_info, HttpSession session) {
        String originalFilename = file.getOriginalFilename();
//        String realPath = request.getServletContext().getRealPath("static/images/touxiang");
        String realPath ="E:\\TCMP077cx\\github\\MusicProject\\qymusic\\target\\classes\\static\\images\\touxiang\\";
        String extension = FilenameUtils.getExtension(originalFilename);
        String newFileName=System.currentTimeMillis()+"_"+ RandomUtils.nextInt(10000)+"_."+extension;
        File file1 = new File(realPath, newFileName);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user_info.setImg("/images/touxiang/" + newFileName);
        userinfoServicecx.updUserinfo(user_info,userId);
        model.addAttribute("img",user_info.getImg());
        session.setAttribute("img",user_info.getImg());
//        System.out.println(userId);
//        System.out.println("/images/touxiang/" + newFileName);
        return "redirect:/";
    }


}
