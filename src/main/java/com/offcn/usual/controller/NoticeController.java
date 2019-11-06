package com.offcn.usual.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.Stringutils.StringUtils;
import com.offcn.usual.bean.Baoxiao;
import com.offcn.usual.bean.Notice;
import com.offcn.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> getAllBaoXiao(HttpServletRequest request, @RequestParam(value ="rowNum",defaultValue = "1") Integer rowNum){
        //请求的controller地址：/prm/bx/all，返回到页面
        String uri = request.getRequestURI();
        //查询后台

        PageInfo<Notice> page=noticeService.showAll(rowNum);
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("page",page);
        map.put("uri",uri);
        return map;
    }
    @RequestMapping("/saveinfo")
    public ModelAndView saveinfo(Notice notice){
        ModelAndView mv=new ModelAndView();
        noticeService.saveinfo(notice);
        mv.setViewName("notice");
        return mv;
    }
}
