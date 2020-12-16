package com.ruoyi.project.system.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.system.hr.emp.domain.Emp;

import java.util.Date;

/**
 * @author BUG KING
 * @date 2020/12/14 21:40
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public class Task {
    private Integer tid;
    //任务标题
    private String title;
    //执行雇员
    private Emp experson;
    //任务内容
    private String t_content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date starttime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;
    //紧急程度
    private  String priority;
    //任务状态
    private String exstatus;
    //创建者
    private String creatby;
    //创建时间
    private Date creattime;


    public Task() {
    }

    public Task(Integer tid, String title, Emp experson, String t_content, Date starttime, Date endtime, String priority, String exstatus, String creatby, Date creattime) {
        this.tid = tid;
        this.title = title;
        this.experson = experson;
        this.t_content = t_content;
        this.starttime = starttime;
        this.endtime = endtime;
        this.priority = priority;
        this.exstatus = exstatus;
        this.creatby = creatby;
        this.creattime = creattime;
    }

    /**
     * 获取
     * @return tid
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置
     * @param tid
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return experson
     */
    public Emp getExperson() {
        return experson;
    }

    /**
     * 设置
     * @param experson
     */
    public void setExperson(Emp experson) {
        this.experson = experson;
    }

    /**
     * 获取
     * @return t_content
     */
    public String getT_content() {
        return t_content;
    }

    /**
     * 设置
     * @param t_content
     */
    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    /**
     * 获取
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取
     * @return endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 设置
     * @param priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 获取
     * @return exstatus
     */
    public String getExstatus() {
        return exstatus;
    }

    /**
     * 设置
     * @param exstatus
     */
    public void setExstatus(String exstatus) {
        this.exstatus = exstatus;
    }

    /**
     * 获取
     * @return creatby
     */
    public String getCreatby() {
        return creatby;
    }

    /**
     * 设置
     * @param creatby
     */
    public void setCreatby(String creatby) {
        this.creatby = creatby;
    }

    /**
     * 获取
     * @return creattime
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * 设置
     * @param creattime
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Task{tid = " + tid + ", title = " + title + ", experson = " + experson + ", t_content = " + t_content + ", starttime = " + starttime + ", endtime = " + endtime + ", priority = " + priority + ", exstatus = " + exstatus + ", creatby = " + creatby + ", creattime = " + creattime + "}";
    }
}
