package com.offcn.auth.service;

import com.offcn.auth.bean.Sources;
import com.offcn.auth.mapper.SourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourcesService {

    @Autowired
    private SourcesMapper sourcesMapper;

    public List<Sources> getSourcesListByPid(int i) {
        List<Sources> sources= sourcesMapper.getSourcesListByPid(i);
        return sources;
    }

    public void saveInfo(Sources sources) {
        sourcesMapper.saveInfo(sources);
    }

    public Sources getOneById(Integer sid) {
      return   sourcesMapper.getOneById(sid);
    }

    public void updateInfo(Sources sources) {
        sourcesMapper.updateInfo(sources);
    }

    public void delete(String id) {
        sourcesMapper.delete(id);
    }

    public List<Sources> getSourcesByEid(int eid) {
        List<Sources> sources = sourcesMapper.getSourcesByEid(eid,1);
        for (Sources source : sources) {
            Integer id = source.getId();
            List<Sources> list = sourcesMapper.getSourcesByEid(eid, id);
            source.setChildren(list);
        }
        return sources;
    }
}
