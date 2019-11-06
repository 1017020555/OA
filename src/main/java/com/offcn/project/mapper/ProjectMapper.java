package com.offcn.project.mapper;
import java.util.List;

import com.offcn.cust.bean.Customer;
import com.offcn.project.bean.Attachment;
import com.offcn.project.bean.Project;
import com.offcn.project.bean.ProjectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMapper {

    List<Project> getAllProjects();

    List<Customer> getAllProName();

    Customer getAllProName2(String id);

    Project getAllProName3(String cid);

    List<Project> sub(@Param("cid") Integer cid,@Param("key") String key,@Param("ord") String ord);
    List<Project> sub1(@Param("cid") Integer cid,@Param("key") String key,@Param("ord") String ord);

    List<Project> attachement();

    void upload(String attname, String attdis, String pa, String remark);
}