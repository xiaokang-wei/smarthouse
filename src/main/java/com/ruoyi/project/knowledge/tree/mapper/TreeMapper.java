package com.ruoyi.project.knowledge.tree.mapper;

import com.ruoyi.project.knowledge.patent.domain.PatentVO;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.hr.dept.domain.HrDept;
import com.ruoyi.project.system.hr.emp.domain.Emp;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/15 20:57
 */
public interface TreeMapper {

    Integer selectDIdByEmpNo(Integer empNo) ;

    HrDept selectDeptById(Integer deptId);

    List<Emp> selectEmpList();

    List<HrDept> selectDeptList();
}
