package com.group.music.qymusic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shkstart
 * @create 2020-11-12 9:10
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/bangdan.html").setViewName("bangdan.html");
        registry.addViewController("/musician.html").setViewName("musician.html");
        registry.addViewController("/musicRadio.html").setViewName("musicRadio.html");
        registry.addViewController("/musicSearchTest.html").setViewName("musicSearchTest.html");
        registry.addViewController("/mv.html").setViewName("mv.html");
        registry.addViewController("/mymusic.html").setViewName("mymusic.html");
        registry.addViewController("/QQmusic.html").setViewName("QQmusic.html");
        registry.addViewController("/register.html").setViewName("register.html");
        registry.addViewController("/resetpassword.html").setViewName("resetpassword.html");
        registry.addViewController("/singer.html").setViewName("singer.html");
        registry.addViewController("/songlist.html").setViewName("songlist.html");
        registry.addViewController("/test.html").setViewName("test.html");
        registry.addViewController("/aaa.html").setViewName("aaa.html");
    }
}
