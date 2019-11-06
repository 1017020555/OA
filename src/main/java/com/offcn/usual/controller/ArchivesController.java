package com.offcn.usual.controller;

import com.offcn.usual.bean.Archives;
import com.offcn.usual.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/archive")
public class ArchivesController {
    @Autowired
    private ArchivesService archivesService;

    @RequestMapping("/getAll")
    public ModelAndView getAll(){
        ModelAndView mv=new ModelAndView();
        List<Archives> lists= archivesService.getAll();
        mv.setViewName("archives");
        mv.addObject("lists",lists);
        return mv;
    }
}
