package com.offcn.usual.service;

import com.offcn.usual.bean.Archives;
import com.offcn.usual.bean.ArchivesExample;
import com.offcn.usual.mapper.ArchivesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivesService {
    @Autowired
    private ArchivesMapper archivesMapper;

    public List<Archives> getAll() {
        return  archivesMapper.getAll();
    }
}
