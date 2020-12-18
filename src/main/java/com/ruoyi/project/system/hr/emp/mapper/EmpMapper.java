package com.ruoyi.project.system.hr.emp.mapper;

import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.hr.emp.vo.EmpVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 21:06
 * 今天写完十万个Bug了吗？
 */
public interface EmpMapper {
    List<EmpVO> selectEmpList(Emp emp);

    int updateEmp(Emp emp);

    int insertEmp(Emp emp);

    int selectMaxEmpNo();

    List<EmpVO> selectMgr();

    EmpVO selectEmpListById(@Param("eId") Integer eId);

    EmpVO selectMgrById(@Param("eId") Integer eId);

    List<Integer> selectByEmpNo(@Param("empNo") Integer empNo);

    List<Emp> selectPostList();

    int removeEmpById(String[] ids);

    List<Emp> selectEmpByIds(String[] ids);
}

