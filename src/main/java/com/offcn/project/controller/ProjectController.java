package com.offcn.project.controller;

import com.alibaba.fastjson.JSON;
import com.offcn.cust.bean.Customer;
import com.offcn.project.bean.Attachment;
import com.offcn.project.bean.Project;
import com.offcn.project.service.ProjectService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value="/download",method=RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request,String filename) throws IOException {
        String realPath="E:\\BaiduNetdiskDownload\\ssm\\prm\\target\\test\\upload";
        filename="ase65ad034278541b69644d28c428cfb7d.txt";

        File file = new File(realPath, filename);//把下载文件构成一个文件处理   filename:前台传过来的文件名称

        HttpHeaders headers = new HttpHeaders();//设置头信息
        String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");//设置响应的文件名

        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // MediaType:互联网媒介类型 contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public ModelAndView upload(String attname,String attdis, MultipartFile path,
                               String remark, HttpServletRequest request) throws IOException {
        ModelAndView mv=new ModelAndView();

        ServletContext context = request.getServletContext();
        String pa=context.getRealPath("/upload");

        File file=new File(pa);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename=attname+UUID.randomUUID().toString().replaceAll("-","")+path.getOriginalFilename().toString().substring(path.getOriginalFilename().lastIndexOf("."));
        path.transferTo(new File(pa+"/"+filename));

        projectService.upload(attname,attdis,pa,remark);
        return mv;
    }

    @RequestMapping("/att")
    public ModelAndView attachement(){
        ModelAndView mv=new ModelAndView();

        List<Project> lists=projectService.attachement();
        mv.addObject("lists",lists);
        mv.setViewName("project-file");
        return mv;
    }

    @RequestMapping("/sub")
    public ModelAndView sub(Integer cid,String keyword,Integer orderby){
        ModelAndView mv=new ModelAndView();
        List<Project> projects= projectService.sub(cid,keyword,orderby);

        mv.addObject("projects",projects);
        mv.setViewName("project-base");
        return mv;
    }
    @RequestMapping("/lis")
    @ResponseBody
    public List<Project> getAllPro(){
        List<Project> lists=projectService.getAllProject();
        return lists;
    }

    @RequestMapping("/list")
    public ModelAndView getAllProject(){
        ModelAndView mv=new ModelAndView();
        List<Project> lists=projectService.getAllProject();

        mv.addObject("projects",lists);
        mv.setViewName("project-base");
        return mv;
    }
    @RequestMapping("/list1")
    public ModelAndView getAllProject1(){
        ModelAndView mv=new ModelAndView();
        List<Project> lists=projectService.getAllProject();
        mv.addObject("ss",lists);
        mv.setViewName("project-base-add");
        return mv;
    }
    @RequestMapping("/getAllProName1")
    public String a(){
        return "project-base-add";
    }
    @RequestMapping("/getAllProName")
    @ResponseBody
    public List<Customer> getAllProName(){
        List<Customer> lists1=projectService.getAllProName();
        return lists1;
    }
    @RequestMapping("/getAllProName2")
    @ResponseBody
    public Customer getAllProName2(@Param("id") String id){
        Customer lists1=projectService.getAllProName2(id);
        return lists1;
    }
    @RequestMapping("/getAllProName3")
    @ResponseBody
    public Project getAllProName3(@Param("cid") String cid){
        Project lists1=projectService.getAllProName3(cid);

        return lists1;
    }
}
