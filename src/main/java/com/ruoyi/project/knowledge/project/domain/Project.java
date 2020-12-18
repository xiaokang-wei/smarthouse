package com.ruoyi.project.knowledge.project.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

import java.util.Date;

/**
 * @author wxk
 * @date 2020/12/17 15:59
 */
public class Project {
    private Integer pId;
    @Excel(name = "项目编号")
    private Integer pNo;
    @Excel(name = "项目描述")
    private String pDesc;
    @Excel(name = "项目开始时间")
    private Date pStartTime;
    @Excel(name = "项目结束时间")
    private Date pEndTime;
    private String pImg;
    @Excel(name = "是否标杆项目")
    private String mark;
    private String pSrc;


    public Project() {
    }

    public Project(Integer pId, Integer pNo, String pDesc, Date pStartTime, Date pEndTime, String pImg, String mark, String pSrc) {
        this.pId = pId;
        this.pNo = pNo;
        this.pDesc = pDesc;
        this.pStartTime = pStartTime;
        this.pEndTime = pEndTime;
        this.pImg = pImg;
        this.mark = mark;
        this.pSrc = pSrc;
    }

    /**
     * 获取
     * @return pId
     */
    public Integer getPId() {
        return pId;
    }

    /**
     * 设置
     * @param pId
     */
    public void setPId(Integer pId) {
        this.pId = pId;
    }

    /**
     * 获取
     * @return pNo
     */
    public Integer getPNo() {
        return pNo;
    }

    /**
     * 设置
     * @param pNo
     */
    public void setPNo(Integer pNo) {
        this.pNo = pNo;
    }

    /**
     * 获取
     * @return pDesc
     */
    public String getPDesc() {
        return pDesc;
    }

    /**
     * 设置
     * @param pDesc
     */
    public void setPDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    /**
     * 获取
     * @return pStartTime
     */
    public Date getPStartTime() {
        return pStartTime;
    }

    /**
     * 设置
     * @param pStartTime
     */
    public void setPStartTime(Date pStartTime) {
        this.pStartTime = pStartTime;
    }

    /**
     * 获取
     * @return pEndTime
     */
    public Date getPEndTime() {
        return pEndTime;
    }

    /**
     * 设置
     * @param pEndTime
     */
    public void setPEndTime(Date pEndTime) {
        this.pEndTime = pEndTime;
    }

    /**
     * 获取
     * @return pImg
     */
    public String getPImg() {
        return pImg;
    }

    /**
     * 设置
     * @param pImg
     */
    public void setPImg(String pImg) {
        this.pImg = pImg;
    }

    /**
     * 获取
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 获取
     * @return pSrc
     */
    public String getPSrc() {
        return pSrc;
    }

    /**
     * 设置
     * @param pSrc
     */
    public void setPSrc(String pSrc) {
        this.pSrc = pSrc;
    }

    public String toString() {
        return "Project{pId = " + pId + ", pNo = " + pNo + ", pDesc = " + pDesc + ", pStartTime = " + pStartTime + ", pEndTime = " + pEndTime + ", pImg = " + pImg + ", mark = " + mark + ", pSrc = " + pSrc + "}";
    }
}
