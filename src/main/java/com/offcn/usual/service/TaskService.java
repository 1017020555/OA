package com.offcn.usual.service;

import com.offcn.usual.bean.Task;
import com.offcn.usual.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public List<Task> getAll() {
        return taskMapper.getAll();
    }
}
