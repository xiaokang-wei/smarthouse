package com.ruoyi.project.knowledge.patent.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

import java.util.Date;

/**
 * @author wxk
 * @date 2020/12/14 22:20
 */
public class PatentVO extends Patent{
    @Excel(name = "专利所属部门")
    private String dName;
    @Excel(name = "专利著作人")
    private String eName;


    public PatentVO() {
    }

    public PatentVO(String dName, String eName) {
        this.dName = dName;
        this.eName = eName;
    }

    /**
     * 获取
     * @return dName
     */
    public String getDName() {
        return dName;
    }

    /**
     * 设置
     * @param dName
     */
    public void setDName(String dName) {
        this.dName = dName;
    }

    /**
     * 获取
     * @return eName
     */
    public String getEName() {
        return eName;
    }

    /**
     * 设置
     * @param eName
     */
    public void setEName(String eName) {
        this.eName = eName;
    }

    public String toString() {
        return "PatentVO{dName = " + dName + ", eName = " + eName + "}";
    }
}
