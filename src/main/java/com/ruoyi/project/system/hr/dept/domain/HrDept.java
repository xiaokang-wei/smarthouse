package com.ruoyi.project.system.hr.dept.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.models.auth.In;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 19:46
 * 今天写完十万个Bug了吗？
 */
public class HrDept extends BaseEntity {
    private Integer dId;
    private String deptName;
    private Integer dPid;
    private String parentName;
    private Integer status;


    public HrDept() {
    }

    public HrDept(Integer dId, String deptName, Integer dPid, String parentName, Integer status) {
        this.dId = dId;
        this.deptName = deptName;
        this.dPid = dPid;
        this.parentName = parentName;
        this.status = status;
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

    /**
     * 获取
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取
     * @return dPid
     */
    public Integer getDPid() {
        return dPid;
    }

    /**
     * 设置
     * @param dPid
     */
    public void setDPid(Integer dPid) {
        this.dPid = dPid;
    }

    /**
     * 获取
     * @return parentName
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 设置
     * @param parentName
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "HrDept{dId = " + dId + ", deptName = " + deptName + ", dPid = " + dPid + ", parentName = " + parentName + ", status = " + status + "}";
    }
}
