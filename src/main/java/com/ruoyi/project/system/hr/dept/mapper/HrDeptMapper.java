package com.ruoyi.project.system.hr.dept.mapper;

import com.ruoyi.project.system.hr.dept.domain.HrDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/15 10:23
 * 今天写完十万个Bug了吗？
 */
public interface HrDeptMapper {
    List<HrDept> selectDeptList(HrDept dept);

    HrDept selectDeptById(@Param("dId") Integer dId);

    List<String> selectEmpDeptTree(@Param("dId") Integer eId);


    int insertDept(@Param("dept")HrDept dept, @Param("dPid") Integer parentId);

    HrDept selectDeptByNameAndPid(@Param("deptName")String deptName, @Param("dPid") Integer parentId);

    int updateDept(HrDept hrDept);

    int selectDeptCount(@Param("dId")Long dId);

    int checkDeptExistUser(@Param("dId") Long dId);

    int deleteDeptById(@Param("dId") Long dId);
}
