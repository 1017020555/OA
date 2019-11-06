package com.offcn.project.service;

import com.offcn.cust.bean.Customer;
import com.offcn.project.bean.Attachment;
import com.offcn.project.bean.Project;
import com.offcn.project.bean.ProjectExample;
import com.offcn.project.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectMapper mapper;

    public List<Project> getAllProject() {
        List<Project> projects = mapper.attachement();
        return projects;
    }

    public List<Customer> getAllProName() {
        return mapper.getAllProName();
    }

    public Customer getAllProName2(String id) {
        return mapper.getAllProName2(id);
    }

    public Project getAllProName3(String cid) {
        return mapper.getAllProName3(cid);
    }

    public List<Project> sub(Integer cid, String keyword, Integer orderby) {
        List<Project> lists=null;
        String key="";
        String ord="";
        if(cid==2){
            if (orderby==1){
                key+="%"+keyword+"%";
                ord="buildtime";
                lists=mapper.sub(cid,key,ord);
            }
            if (orderby==2){
                key+="%"+keyword+"%";
                ord="endtime";
                lists=mapper.sub1(cid,key,ord);
            }
        }
        return lists;
    }


    public List<Project> attachement() {
        return mapper.attachement();
    }

    public void upload(String attname, String attdis, String pa, String remark) {
        mapper.upload(attname,attdis,pa,remark);
    }
}
