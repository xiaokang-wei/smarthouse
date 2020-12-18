package com.ruoyi.project.knowledge.project.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

import java.util.Date;

/**
 * @author wxk
 * @date 2020/12/17 15:59
 */
public class ProjectVO extends Project{
    @Excel(name = "项目名称")
    private  String pName;


    public ProjectVO() {
    }

    public ProjectVO(String pName) {
        this.pName = pName;
    }

    /**
     * 获取
     * @return pName
     */
    public String getPName() {
        return pName;
    }

    /**
     * 设置
     * @param pName
     */
    public void setPName(String pName) {
        this.pName = pName;
    }

    public String toString() {
        return "ProjectVO{pName = " + pName + "}";
    }
}
