package com.offcn.usual.mapper;

import com.offcn.usual.bean.Task;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {
    List<Task> getAll();
}