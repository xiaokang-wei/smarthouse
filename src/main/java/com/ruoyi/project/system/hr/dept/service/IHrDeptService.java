package com.ruoyi.project.system.hr.dept.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.hr.dept.domain.HrDept;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.role.domain.Role;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/15 10:23
 * 今天写完十万个Bug了吗？
 */
public interface IHrDeptService {
    List<HrDept> selectDeptList(HrDept dept);

    HrDept selectDeptById(Integer dId);

    List<Ztree> selectDeptTree(HrDept dept);


    String checkDeptNameUnique(String deptName,Integer parentId);

    int insertDept(HrDept dept,Integer parentId);

    int updateDept(HrDept hrDept);

    int selectDeptCount(Long dId);

    boolean checkDeptExistUser(Long dId);

    boolean deleteDeptById(Long dId);
}
