package com.offcn.usual.mapper;

import com.offcn.usual.bean.Baoxiao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaoXiaoMapper {

    List<Baoxiao> getAllBaoXiao(@Param("status") Integer status,@Param("keyword") String keyword);

    List<Baoxiao> getAllBaoXiao1();

    void saveInfo(Baoxiao baoxiao);

    List<Baoxiao> getAllBaoXiao2();
}
