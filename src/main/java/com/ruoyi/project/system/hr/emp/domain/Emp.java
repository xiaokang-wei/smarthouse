package com.ruoyi.project.system.hr.emp.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 19:15
 * 今天写完十万个Bug了吗？
 */
public class Emp extends BaseEntity {
    @Excel(name = "序列号")
    private Integer eId;
    @Excel(name = "雇员编号")
    private Integer empNo;
    @Excel(name = "雇员名称")
    private String eName;
    @Excel(name = "雇员性别")
    private String eSex;
    @Excel(name = "上级编号")
    private Integer mgrNo;
    @Excel(name = "岗位")
    private String post;
    @Excel(name = "手机号码")
    private String phone;
    @Excel(name = "部门编号")
    private Integer deptNo;
    @Excel(name = "状态")
    private String eStatus;

    public Emp() {
    }

    public Emp(Integer eId, Integer empNo, String eName, String eSex, Integer mgrNo, String post, String phone, Integer deptNo, String eStatus) {
        this.eId = eId;
        this.empNo = empNo;
        this.eName = eName;
        this.eSex = eSex;
        this.mgrNo = mgrNo;
        this.post = post;
        this.phone = phone;
        this.deptNo = deptNo;
        this.eStatus = eStatus;
    }

    /**
     * 获取
     * @return eId
     */
    public Integer getEId() {
        return eId;
    }

    /**
     * 设置
     * @param eId
     */
    public void setEId(Integer eId) {
        this.eId = eId;
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

    /**
     * 获取
     * @return eSex
     */
    public String getESex() {
        return eSex;
    }

    /**
     * 设置
     * @param eSex
     */
    public void setESex(String eSex) {
        this.eSex = eSex;
    }

    /**
     * 获取
     * @return mgrNo
     */
    public Integer getMgrNo() {
        return mgrNo;
    }

    /**
     * 设置
     * @param mgrNo
     */
    public void setMgrNo(Integer mgrNo) {
        this.mgrNo = mgrNo;
    }

    /**
     * 获取
     * @return post
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置
     * @param post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return deptNo
     */
    public Integer getDeptNo() {
        return deptNo;
    }

    /**
     * 设置
     * @param deptNo
     */
    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    /**
     * 获取
     * @return eStatus
     */
    public String getEStatus() {
        return eStatus;
    }

    /**
     * 设置
     * @param eStatus
     */
    public void setEStatus(String eStatus) {
        this.eStatus = eStatus;
    }

    @Override
    public String toString() {
        return "Emp{eId = " + eId + ", empNo = " + empNo + ", eName = " + eName + ", eSex = " + eSex + ", mgrNo = " + mgrNo + ", post = " + post + ", phone = " + phone + ", deptNo = " + deptNo + ", eStatus = " + eStatus + "}";
    }
}
