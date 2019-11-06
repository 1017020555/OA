package com.offcn.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.usual.bean.Baoxiao;
import com.offcn.usual.mapper.BaoXiaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BaoXiaoService {
@Autowired
private BaoXiaoMapper baoXiaoMapper;

    public List<Baoxiao> getAllBaoXiao1() {
        return baoXiaoMapper.getAllBaoXiao1();
    }

    public void saveInfo(Baoxiao baoxiao) {
        baoxiao.setBxid(UUID.randomUUID().toString().replaceAll("",""));
        baoXiaoMapper.saveInfo(baoxiao);
    }

    public PageInfo<Baoxiao> getBaoXiaoList(Integer rowNum, Map<String, Object> search) {
        Map<String, String> map = parseParameterMapToMyBatisMap(search);
        String status = map.get("status");
        String keyword = map.get("keyword");
        PageHelper.startPage(rowNum, 5);
        List<Baoxiao> baoXiao = null;

        if (status != null && keyword != null) {
            baoXiao = baoXiaoMapper.getAllBaoXiao(Integer.valueOf(status), keyword);
        }else {
            baoXiao=baoXiaoMapper.getAllBaoXiao2();
        }
        PageInfo<Baoxiao> page = new PageInfo<Baoxiao>(baoXiao, 10);
        return page;
    }
    //将模糊查询和状态查询截取key处理
    private Map<String,String> parseParameterMapToMyBatisMap(Map<String, Object> search) {

        Map<String,String> resultMap=new HashMap<String, String>();

        Set<Map.Entry<String, Object>> entries = search.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            //eq_status
            //like_keyword
            String key = entry.getKey();
            String value=(String) entry.getValue();
            if (key.contains("like")){
                key=key.substring(key.indexOf("_")+1);
                value="%"+value+"%";
            }
            resultMap.put(key,value);
        }
        return resultMap;
    }
}
