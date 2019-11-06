package com.offcn.usual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/echart")
public class EchartController {

    @RequestMapping("/get")
    @ResponseBody
    public Map<String,Object> get(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("a",100);
        map.put("b",20);
        map.put("c",30);
        map.put("d",400);
        map.put("e",80);
        return map;
    }

}
