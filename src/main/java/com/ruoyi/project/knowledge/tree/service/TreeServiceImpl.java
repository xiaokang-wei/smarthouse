package com.ruoyi.project.knowledge.tree.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.knowledge.tree.mapper.TreeMapper;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.hr.dept.domain.HrDept;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxk
 * @date 2020/12/15 20:56
 */
@Service
public class TreeServiceImpl implements TreeService{
    @Autowired
    private TreeMapper treeMapper;


    @Override
    public HrDept selectDeptById(Integer deptId) {
        System.out.println("deptId = " + deptId);
        HrDept hrDept=treeMapper.selectDeptById(deptId);
        System.out.println("dept = " + hrDept);
        return hrDept;
    }

    @Override
    public List<Ztree> selectDeptTree() {
        List<HrDept> deptList = treeMapper.selectDeptList();
        System.out.println("===========================================");
        System.out.println("DEPTList = " + deptList);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }
    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<HrDept> deptList) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<Emp> emps = treeMapper.selectEmpList();
        for (HrDept dept : deptList)
        {
            Ztree ztree = new Ztree();
            Long deptId= dept.getDId().longValue();
            ztree.setId(deptId);
            ztree.setpId(dept.getDPid().longValue());
            ztree.setName(dept.getDeptName());
            ztree.setTitle(dept.getDeptName());
            ztrees.add(ztree);
        }
        for (Emp emp : emps)
        {
            Ztree ztree = new Ztree();
            ztree.setId(emp.getEmpNo().longValue());
            ztree.setpId(emp.getDeptNo().longValue());
            ztree.setName(emp.getEName());
            ztree.setTitle(emp.getEName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
