package com.group.music.qymusic.config;

import com.group.music.qymusic.service.*;
import com.group.music.qymusic.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfigcx implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("index2.html").setViewName("index2.html");
    }

    @Bean
    public LoginServicecx loginServicecx(){
        return new LoginServicecxImpl();
    }

    @Bean
    public UserinfoServicecx userinfoServicecx(){
        return new UserinfoServicecxImpl();
    }

    @Bean
    public UsermusicServicecx usermusicServicecx(){
        return new UsermusicServicecxImpl();
    }

    @Bean
    public MusicServicecx musicServicecx(){return new MusicServicecxImpl(); }

    @Bean
    public SingerServicecx singerServicecx(){return new SingerServicecxImpl(); }

    @Bean
    public MusiclistServicecx musiclistServicecx(){return new MusiclistServicecxImpl(); }

    @Bean
    public MusiclistInfoServicecx musiclistInfoServicecx(){return new MusiclistInfoServicecxImpl();}


}
