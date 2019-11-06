package com.offcn.usual.controller;

import com.alibaba.fastjson.JSON;
import com.offcn.usual.bean.Task;
import com.offcn.usual.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/getAll")

    public  ModelAndView getAll(){
        List<Task> tasks= taskService.getAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("tasks", JSON.toJSONString(tasks));

        System.out.println(JSON.toJSONString(tasks));

        mv.setViewName("task-add");
        return mv;
    }
}
