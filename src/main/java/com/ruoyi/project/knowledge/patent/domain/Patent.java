package com.ruoyi.project.knowledge.patent.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

/**
 * @author wxk
 * @date 2020/12/14 21:25
 */
    public class Patent extends BaseEntity {
    @Excel(name = "专利编码")
    private Integer patentId;
    @Excel(name = "专利名")
    private String patentName;
    @Excel(name = "专利类型")
    private String patentType;
    @Excel(name = "专利作者")
    private Integer patentAuthor;
    @Excel(name = "专利发表时间")
    private Date patentPublicTime;
    @Excel(name = "专利状态")
    private String patentStatus;

    private Integer dId;


    public Patent() {
    }

    public Patent(Integer patentId, String patentName, String patentType, Integer patentAuthor, Date patentPublicTime, String patentStatus, Integer dId) {
        this.patentId = patentId;
        this.patentName = patentName;
        this.patentType = patentType;
        this.patentAuthor = patentAuthor;
        this.patentPublicTime = patentPublicTime;
        this.patentStatus = patentStatus;
        this.dId = dId;
    }

    /**
     * 获取
     * @return patentId
     */
    public Integer getPatentId() {
        return patentId;
    }

    /**
     * 设置
     * @param patentId
     */
    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    /**
     * 获取
     * @return patentName
     */
    public String getPatentName() {
        return patentName;
    }

    /**
     * 设置
     * @param patentName
     */
    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    /**
     * 获取
     * @return patentType
     */
    public String getPatentType() {
        return patentType;
    }

    /**
     * 设置
     * @param patentType
     */
    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    /**
     * 获取
     * @return patentAuthor
     */
    public Integer getPatentAuthor() {
        return patentAuthor;
    }

    /**
     * 设置
     * @param patentAuthor
     */
    public void setPatentAuthor(Integer patentAuthor) {
        this.patentAuthor = patentAuthor;
    }

    /**
     * 获取
     * @return patentPublicTime
     */
    public Date getPatentPublicTime() {
        return patentPublicTime;
    }

    /**
     * 设置
     * @param patentPublicTime
     */
    public void setPatentPublicTime(Date patentPublicTime) {
        this.patentPublicTime = patentPublicTime;
    }

    /**
     * 获取
     * @return patentStatus
     */
    public String getPatentStatus() {
        return patentStatus;
    }

    /**
     * 设置
     * @param patentStatus
     */
    public void setPatentStatus(String patentStatus) {
        this.patentStatus = patentStatus;
    }

    /**
     * 获取
     * @return dId
     */
    public Integer getDId() {
        return dId;
    }

    /**
     * 设置
     * @param dId
     */
    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public String toString() {
        return "Patent{patentId = " + patentId + ", patentName = " + patentName + ", patentType = " + patentType + ", patentAuthor = " + patentAuthor + ", patentPublicTime = " + patentPublicTime + ", patentStatus = " + patentStatus + ", dId = " + dId + "}";
    }
}
