package com.group.music.qymusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.group.music.qymusic.mapper")
@SpringBootApplication
public class QymusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(QymusicApplication.class, args);
    }

}
