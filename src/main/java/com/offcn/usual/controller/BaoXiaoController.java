package com.offcn.usual.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.usual.bean.Baoxiao;
import com.offcn.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/bx")
public class BaoXiaoController {

    @Autowired
    private BaoXiaoService baoXiaoService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(String paymode,String totalmoney,String bxtime,String bxremark) throws ParseException {
        Baoxiao baoxiao=new Baoxiao();
        baoxiao.setPaymode(paymode);
        baoxiao.setTotalmoney(Double.valueOf(totalmoney));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        baoxiao.setBxtime(sdf.parse(bxtime));
        baoxiao.setBxremark(bxremark);
        baoXiaoService.saveInfo(baoxiao);
        return "/bx/all";
    }

    @RequestMapping("/zclx")
    @ResponseBody
    public  List<Baoxiao> zclx(){
        List<Baoxiao> lxs= baoXiaoService.getAllBaoXiao1();
        return lxs;
    }
    @RequestMapping("/all")
    public ModelAndView getAllBaoXiao(HttpServletRequest request, @RequestParam(value ="rowNum",defaultValue = "1") Integer rowNum){
        ModelAndView mv=new ModelAndView();
        Map<String, Object> search = WebUtils.getParametersStartingWith(request, "search_");

        //对关键字处理拼接返回前台
        String queryStr= parseparameterMapToString(search);
        //请求的controller地址：/prm/bx/all，返回到页面
        String uri = request.getRequestURI();
        //查询后台
        PageInfo<Baoxiao> page=baoXiaoService.getBaoXiaoList(rowNum,search);

        mv.addObject("uri",uri);
        mv.addObject("queryStr",queryStr);
        mv.addObject("page",page);
        mv.setViewName("mybaoxiao-base");
           return mv;
    }

    private String parseparameterMapToString(Map<String, Object> search) {
        Set<Map.Entry<String, Object>> entries = search.entrySet();
        String str="";
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = (String)entry.getValue();
            str=str+"&"+"search_"+key+"="+value;
        }
        return str;
    }

}
