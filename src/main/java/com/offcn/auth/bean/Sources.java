package com.offcn.auth.bean;

import java.util.ArrayList;
import java.util.List;

public class Sources {
   private Integer id;
   private String name;
   private String url;
   private String remark;
   private Integer pid;
   private String icon;

    private boolean open=false;
    private List<Sources> children=new ArrayList<Sources>();

    public List<Sources> getChildren() {
        return children;
    }

    public void setChildren(List<Sources> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Sources{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", remark='" + remark + '\'' +
                ", pid=" + pid +
                ", icon='" + icon + '\'' +
                ", open=" + open +
                ", children=" + children +
                '}';
    }
}