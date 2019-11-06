package com.offcn.usual.bean;

import com.offcn.project.bean.Employee;
import com.offcn.project.bean.Function;

import java.util.Date;

public class Task {
    private Integer id;

    private Date starttime;

    private Date endtime;

    private String level;

    private String define;

    private String remark;

    private Integer funFk;

    private Integer empFk2;

    private Integer empFk;
    private String  tasktitle;
    private Integer status;


private Function function;
    public Function getFunction() {
        return function;
    }
    public void setFunction(Function function) {
        this.function = function;
    }
private Employee employee;
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define == null ? null : define.trim();
    }

    public Integer getFunFk() {
        return funFk;
    }

    public void setFunFk(Integer funFk) {
        this.funFk = funFk;
    }

    public Integer getEmpFk2() {
        return empFk2;
    }

    public void setEmpFk2(Integer empFk2) {
        this.empFk2 = empFk2;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", level='" + level + '\'' +
                ", define='" + define + '\'' +
                ", remark='" + remark + '\'' +
                ", funFk=" + funFk +
                ", empFk2=" + empFk2 +
                ", empFk=" + empFk +
                ", tasktitle='" + tasktitle + '\'' +
                ", status=" + status +
                ", function=" + function +
                ", employee=" + employee +
                '}';
    }
}