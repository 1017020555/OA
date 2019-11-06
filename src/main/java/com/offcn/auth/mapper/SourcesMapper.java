package com.offcn.auth.mapper;

import com.offcn.auth.bean.Sources;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourcesMapper {

    List<Sources> getSourcesListByPid(@Param("id") int id);

    void saveInfo(Sources sources);

    Sources getOneById(Integer sid);

    void updateInfo(Sources sources);

    void delete(String id);

    List<Sources> getSourcesByEid(@Param("eid")int eid,@Param("pid")int pid);
}