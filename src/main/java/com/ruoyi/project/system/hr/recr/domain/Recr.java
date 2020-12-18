package com.ruoyi.project.system.hr.recr.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/17 15:57
 * 今天写完十万个Bug了吗？
 */
public class Recr  {
    @Excel(name = "编号")
    private Integer rId;
    @Excel(name = "招聘标题")
    private String title;
    @Excel(name = "申请人编号")
    private Integer empNo;
    @Excel(name = "审批状态")
    private String approStatus;
    @Excel(name = "申请原因")
    private String content;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name="创建时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date creatTime;
    @Excel(name = "申请人")
    private String applicant;


    public Recr() {
    }

    public Recr(Integer rId, String title, Integer empNo, String approStatus, String content, Date creatTime, String applicant) {
        this.rId = rId;
        this.title = title;
        this.empNo = empNo;
        this.approStatus = approStatus;
        this.content = content;
        this.creatTime = creatTime;
        this.applicant = applicant;
    }

    /**
     * 获取
     * @return rId
     */
    public Integer getRId() {
        return rId;
    }

    /**
     * 设置
     * @param rId
     */
    public void setRId(Integer rId) {
        this.rId = rId;
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
     * @return empNo
     */
    public Integer getEmpNo() {
        return empNo;
    }

    /**
     * 设置
     * @param empNo
     */
    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    /**
     * 获取
     * @return approStatus
     */
    public String getApproStatus() {
        return approStatus;
    }

    /**
     * 设置
     * @param approStatus
     */
    public void setApproStatus(String approStatus) {
        this.approStatus = approStatus;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return creatTime
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 获取
     * @return applicant
     */
    public String getApplicant() {
        return applicant;
    }

    /**
     * 设置
     * @param applicant
     */
    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Recr{rId = " + rId + ", title = " + title + ", empNo = " + empNo + ", approStatus = " + approStatus + ", content = " + content + ", creatTime = " + creatTime + ", applicant = " + applicant + "}";
    }
}
