package com.offcn.employee.bean;
import java.util.Date;

public class Email {

private Integer id;
private String title;
private String ename;
private Date sendtime;
private String content;
private Employee employee;
private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ename='" + ename + '\'' +
                ", sendtime=" + sendtime +
                ", content='" + content + '\'' +
                ", employee=" + employee +
                ", path='" + path + '\'' +
                '}';
    }
}
