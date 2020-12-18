package com.ruoyi.project.system.hr.emp.vo;

import com.ruoyi.project.system.hr.emp.domain.Emp;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 20:58
 * 今天写完十万个Bug了吗？
 */
public class EmpVO extends Emp {
    private String mgr;
    private String deptName;

    public EmpVO() {
    }

    public EmpVO(String mgr, String deptName) {
        this.mgr = mgr;
        this.deptName = deptName;
    }

    /**
     * 获取
     * @return mgr
     */
    public String getMgr() {
        return mgr;
    }

    /**
     * 设置
     * @param mgr
     */
    public void setMgr(String mgr) {
        this.mgr = mgr;
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

    public String toString() {
        return "EmpVO{mgr = " + mgr + ", deptName = " + deptName + "}";
    }
}
