package com.offcn.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.usual.bean.Baoxiao;
import com.offcn.usual.bean.Notice;
import com.offcn.usual.bean.NoticeExample;
import com.offcn.usual.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    public void saveinfo(Notice notice) {
        Notice notice1=new Notice();
        notice1.setNdate(new Date());
        notice1.setNtitle(notice.getNtitle());
        notice1.setRemark(notice.getRemark());
        noticeMapper.insert(notice1);
    }

    public PageInfo<Notice> showAll(Integer rowNum) {
        PageHelper.startPage(rowNum, 5);
        List<Notice> notices = noticeMapper.showAll();
        PageInfo<Notice> page = new PageInfo<Notice>(notices, 10);
        return page;
    }

}
