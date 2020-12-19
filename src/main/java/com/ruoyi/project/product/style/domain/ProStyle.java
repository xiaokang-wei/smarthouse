package com.ruoyi.project.product.style.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProStyle extends BaseEntity {
    private Integer ppsId;
        private String pName;
    private String pNote;


    public ProStyle() {
    }

    public ProStyle(Integer ppsId, String pName, String pNote) {
        this.ppsId = ppsId;
        this.pName = pName;
        this.pNote = pNote;
    }

    /**
     * 获取
     * @return ppsId
     */
    public Integer getPpsId() {
        return ppsId;
    }

    /**
     * 设置
     * @param ppsId
     */
    public void setPpsId(Integer ppsId) {
        this.ppsId = ppsId;
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

    /**
     * 获取
     * @return pNote
     */
    public String getPNote() {
        return pNote;
    }

    /**
     * 设置
     * @param pNote
     */
    public void setPNote(String pNote) {
        this.pNote = pNote;
    }

    public String toString() {
        return "ProStyle{ppsId = " + ppsId + ", pName = " + pName + ", pNote = " + pNote + "}";
    }
}
