package com.offcn.auth.controller;
import com.offcn.auth.bean.Sources;
import com.offcn.auth.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sources")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping("/getSourcesByEid")
    public String getSourcesByEid(HttpSession session){
       List<Sources> lists= sourcesService.getSourcesByEid(2);
       session.setAttribute("lists",lists);
       return "menu";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> delete(String id){
        sourcesService.delete(id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("statusCode","200");
        return map;
    }

    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public ModelAndView updateInfo(Sources sources){
        ModelAndView mv=new ModelAndView();
        sourcesService.updateInfo(sources);
        mv.setViewName("pm");
        return mv;
    }

    @RequestMapping(value = "/getOneById",method = RequestMethod.GET)
    public ModelAndView getOneById(String id){
        Sources sources= sourcesService.getOneById(Integer.valueOf(id));
        ModelAndView mv=new ModelAndView();
        mv.addObject("onesource",sources);
        mv.setViewName("pm-edit");
        return mv;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String saveInfo(Sources sources){
        sourcesService.saveInfo(sources);
        return "pm";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Sources> getSourcesList(){
        List<Sources> lists= sourcesService.getSourcesListByPid(0);
        queryChild(lists.get(0));
        return lists;
    }
//递归查询子菜单
    private void queryChild(Sources sources) {
        Integer id = sources.getId();
        List<Sources> sourcesList = sourcesService.getSourcesListByPid(id);
        //null时结束循环
        for (Sources sources1 : sourcesList) {
            queryChild(sources1);
        }
        sources.setChildren(sourcesList);
    }


}
