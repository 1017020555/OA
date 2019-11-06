package com.offcn.cust.controller;
import com.offcn.cust.bean.Customer;
import com.offcn.cust.service.CustomerService;
import com.offcn.cust.utils.WDWUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/cust")
@Controller
public class CustomerCotroller {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/add")
    public String add(Customer customer){
        customerService.add(customer);
        return "redirect:/cust/list";
    }
    @RequestMapping("/list")
    public ModelAndView getAllCust(){
        ModelAndView mv=new ModelAndView();
        List<Customer> customers=customerService.getAllCust();
        mv.addObject("customers",customers);
        mv.setViewName("customer");
        return mv;
    }

    @RequestMapping("/getCustomer")
    public ModelAndView getCustomer(String id){
        Customer customer=customerService.getCustomer(Integer.valueOf(id));
        ModelAndView mv=new ModelAndView();
        mv.addObject("customer",customer);
        mv.setViewName("customer-look");
        return mv;
    }

    @RequestMapping("/edit")
    public String edit(Customer customer){
        customerService.edit(customer);
        return "redirect:/cust/list";
    }

    @RequestMapping("/edit1")
    public ModelAndView edit1(String id){
        ModelAndView mv=new ModelAndView();
        Customer customer= customerService.edit1(Integer.valueOf(id));
        mv.addObject("customer",customer);
        mv.setViewName("customer-edit");
        return  mv;
    }

    @RequestMapping(value = "/delete")
    public String delete(String ids){
        customerService.delete(ids);
        return "redirect:/cust/list";
    }

    @RequestMapping("/search")
    public ModelAndView search(Integer cid,String keyword,Integer orderby){
        ModelAndView mv=new ModelAndView();
        List<Customer> lists=customerService.search(cid,keyword,orderby);
        mv.setViewName("customer");
        mv.addObject("customers",lists);
        return mv;
    }

    @RequestMapping("/download")
    public String downExcel(HttpServletRequest request) throws Exception {

        List<Customer> customers=customerService.getAllCust();
        String s = WDWUtil.stuList2Excel(customers);

        request.setAttribute("path",s);
        return "redirect:/cust/list";
    }
}
