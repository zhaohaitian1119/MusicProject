package com.group.music.qymusic.service.impl;

import com.group.music.qymusic.mapper.SingerMapper;
import com.group.music.qymusic.pojo.Singer;
import com.group.music.qymusic.pojo.SingerExample;
import com.group.music.qymusic.service.SingerServicecx;

import javax.annotation.Resource;
import java.util.List;

public class SingerServicecxImpl implements SingerServicecx {
    @Resource
    SingerMapper singerMapper;

    @Override
    public List<Singer> selectSinger(Integer id) {
        SingerExample  singerExample=new SingerExample();
        SingerExample.Criteria criteria = singerExample.createCriteria();
        criteria.andIdEqualTo(id);
        return singerMapper.selectByExample(singerExample);
    }
}
