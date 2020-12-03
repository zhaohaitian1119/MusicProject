package com.group.music.qymusic.controller;

import com.group.music.qymusic.pojo.Musiclist;
import com.group.music.qymusic.pojo.User;
import com.group.music.qymusic.pojo.User_info;
import com.group.music.qymusic.pojo.User_music;
import com.group.music.qymusic.service.LoginServicecx;
import com.group.music.qymusic.service.MusiclistServicecx;
import com.group.music.qymusic.service.UserinfoServicecx;
import com.group.music.qymusic.service.UsermusicServicecx;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginControllercx {
    @Resource
    LoginServicecx loginServicecx;
    @Resource
    UserinfoServicecx userinfoServicecx;
    @Resource
    UsermusicServicecx usermusicServicecx;
    @Resource
    MusiclistServicecx musiclistServicecx;

    @RequestMapping("/toUpd")
    public String toUpdUserinfo() {
        return "updUserinfo.html";
    }

    @RequestMapping("/toUpdPassword")
    public String toResetPassword() {
        return "resetpassword.html";
    }

    @RequestMapping("/register.html")
    public String toregister() {
        return "register.html";
    }


    //登录
    @RequestMapping("/user/loginPage")
    @ResponseBody
    public Map<Object, String> loginPage(String user_name, String user_password, Model model, HttpSession session, HttpServletRequest request) {
        Map<Object, String> map = new HashMap<>();
        User user = loginServicecx.login(user_name);
        if (user == null) {
            map.put("statusCode", "1");//没有该用户
        } else if ((user.getPassword().equals(user_password)) == false) {
            map.put("statusCode", "2");//密码错误
        } else {
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getId());
            User_info user_info = userinfoServicecx.selectUserinfo(user.getId());
            String img = user_info.getImg();
            session.setAttribute("img", img);
            map.put("statusCodeimg", img);
            map.put("statusCode", "200");
        }
        return map;
    }

    //注册
    @RequestMapping("/user/addOrEditUser")
    @ResponseBody
    public Map<Object, String> addOrEditUser(User user, String phone, String password, String email,
                                             User_info user_info, Musiclist musiclist, User_music user_music) {
        Map<Object, String> map = new HashMap<>();
        user.setPhone(phone);
        user.setPassword(password);
        user.setEmail(email);
        int i = loginServicecx.add(user);

        User getUserId = loginServicecx.getById(phone);

        //添加用户信息
        user_info.setUserId(getUserId.getId());
        user_info.setUsername(phone);
        user_info.setGender("男");
        user_info.setIntroduce("这个人很懒,什么也没留下");
        user_info.setBirthday(new Date());
        user_info.setRegion(null);
        user_info.setImg("/images/touxiang2.jpg");
        int i2 = userinfoServicecx.addUserinfo(user_info);

        //添加歌单 我喜欢
        musiclist.setName("我喜欢");
        musiclist.setImg("/images/2.jpg");
        musiclist.setIntroduce("我喜欢");
        musiclist.setClickvolume(0);
        musiclist.setType("0");
        musiclistServicecx.addMusiclist(musiclist);

        //添加用户歌单 我喜欢
        user_music.setUserId(getUserId.getId());
        user_music.setMusiclistId(musiclist.getId());


        if (i > 0) {
            map.put("statusCode", "200");
        } else {
            map.put("statusCode", "0");
        }
        return map;
    }

    //修改密码
    @RequestMapping("/user/resetUserPassword")
    @ResponseBody
    public Map<String, Object> updPassword(String password, @RequestParam("password1") String password1, @RequestParam("password2") String password2, User user, @RequestParam("phone") String phone) {
        Map<String, Object> map = new HashMap();
        User login = loginServicecx.login(phone);
        if ((password1.equals(password2)) == false) {
            map.put("statusCode", "1");//两次密码不一致
        } else {
            user.setPassword(password2);
            loginServicecx.updPassword(user);
            map.put("statuscCode", "200");
        }
        return map;
    }

    //手机验证
    private String testStatus() {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api", "3a14f4907cde08279f218e7229468a69"));
        WebResource webResource = client.resource("http://sms-api.luosimao.com/v1/status.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        ClientResponse response = webResource.get(ClientResponse.class);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(status);
        //System.out.print(textEntity);
        return textEntity;
    }

    //手机验证
    @RequestMapping("/dophone")
    @ResponseBody
    public Map<String, Object> doPhone2(HttpSession session, String phone) {
        System.out.println(phone);

        Map<String, Object> map = new HashMap<>();
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api", "524c960032e7f31c53b879e76eeaf7b8"));
//        3a14f4907cde08279f218e7229468a69
        WebResource webResource = client.resource(
                "http://sms-api.luosimao.com/v1/send.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", phone);
        int suiJi = (int) ((Math.random() * 9 + 1) * 100000);

        System.out.println(suiJi);
        session.setAttribute("suiJi", suiJi);

        formData.add("message", "随机生成验证码" + suiJi + "【铁壳测试】");
        ClientResponse response = webResource.type(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        LoginControllercx api = new LoginControllercx();
        String httpResponse = textEntity;
        try {
            JSONObject jsonObj = new JSONObject(httpResponse);
            int error_code = jsonObj.getInt("error");
            String error_msg = jsonObj.getString("msg");
            if (error_code == 0) {
                map.put("suiji", suiJi);
                map.put("status", "true");
                System.out.println("Send message success.");
            } else {
                map.put("status", "false");
                System.out.println("Send message failed,code is " + error_code + ",msg is " + error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(LoginControllercx.class.getName()).log(Level.SEVERE, null, ex);
        }

        httpResponse = api.testStatus();
        try {
            JSONObject jsonObj = new JSONObject(httpResponse);
            int error_code = jsonObj.getInt("error");
            if (error_code == 0) {
                map.put("suiji", suiJi);
                map.put("status", "true");
                int deposit = jsonObj.getInt("deposit");
                System.out.println("Fetch deposit success :" + deposit);
            } else {
                map.put("status", "false");
                String error_msg = jsonObj.getString("msg");
                System.out.println("Fetch deposit failed,code is " + error_code + ",msg is " + error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(LoginControllercx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
}
