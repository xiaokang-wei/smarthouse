package com.ruoyi.project.system.hr.emp.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.hr.emp.mapper.EmpMapper;
import com.ruoyi.project.system.hr.emp.vo.EmpVO;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 19:34
 * 今天写完十万个Bug了吗？
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<EmpVO> selectEmpList(Emp emp) {
        if (emp!=null){
            if (emp.getDeptNo()!=null){
                if(emp.getDeptNo()==100){

                    emp.setDeptNo(null);

                }
            }
        }

            List<EmpVO> empVOList  = empMapper.selectEmpList(emp);
            return empVOList;
    }

    /**
     * 更新状态
     * @param emp
     * @return
     */
    @Override
    public int changeStatus(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    /**
     * 添加
     * @return
     */
    @Override
    public int insertEmp(Emp emp) {
      int row = empMapper.insertEmp(emp);
        return row;
    }

    /**
     * 查询最大的empNo
     * @return
     */
    @Override
    public int selectMaxEmpNo() {
       int empNo = empMapper.selectMaxEmpNo();
        return empNo;
    }

    @Override
    public List<EmpVO> selectMgr() {
      List<EmpVO> empVOList = empMapper.selectMgr();
        return empVOList;
    }

    @Override
    public EmpVO selectEmpListById(Integer eId) {
        EmpVO empVO  =  empMapper.selectEmpListById(eId);
        return empVO;
    }

    @Override
    public EmpVO selectMgrById(Integer eId) {
        EmpVO empVO  =  empMapper.selectMgrById(eId);
        return empVO;
    }

    /**
     * 更新
     * @param emp
     * @return
     */
    @Override
    public int updateEmp(Emp emp) {
      int row = empMapper.updateEmp(emp);
        return row;
    }

    @Override
    public List<Integer> selectByEmpNo(Integer empNo) {
        List<Integer> list = empMapper.selectByEmpNo(empNo);
        return list;
    }

    @Override
    public List<Emp> selectPostList() {
       List<Emp> list = empMapper.selectPostList();
        return list;
    }

    @Override
    public int removeEmpById(String[] ids) {
     int row =  empMapper.removeEmpById(ids);
        return row;
    }

    @Override
    public List<Emp> selectEmpByIds(String[] ids) {
      List<Emp> empList = empMapper.selectEmpByIds(ids);

        return empList;
    }



}
