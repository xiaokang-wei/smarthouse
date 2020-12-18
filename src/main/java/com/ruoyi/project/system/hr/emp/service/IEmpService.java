package com.ruoyi.project.system.hr.emp.service;

import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.hr.emp.vo.EmpVO;
import com.ruoyi.project.system.user.domain.User;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 19:35
 * 今天写完十万个Bug了吗？
 */
public interface IEmpService {
    List<EmpVO> selectEmpList(Emp emp);


    int changeStatus(Emp emp);

    int insertEmp(Emp emp);

    int selectMaxEmpNo();

    List<EmpVO> selectMgr();

    EmpVO selectEmpListById(Integer eId);

    EmpVO selectMgrById(Integer eId);

    int updateEmp(Emp emp);

    List<Integer> selectByEmpNo(Integer empNo);

    List<Emp> selectPostList();

    int removeEmpById(String[] eIds);

    List<Emp> selectEmpByIds(String[] eIds);


}
