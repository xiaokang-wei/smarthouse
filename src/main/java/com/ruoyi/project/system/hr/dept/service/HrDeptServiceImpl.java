package com.ruoyi.project.system.hr.dept.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.hr.dept.domain.HrDept;
import com.ruoyi.project.system.hr.dept.mapper.HrDeptMapper;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.role.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/15 10:24
 * 今天写完十万个Bug了吗？
 */
@Service
public class HrDeptServiceImpl implements IHrDeptService{
    @Autowired
    private HrDeptMapper hrDeptMapper;

    /**
     * 查询所有部门信息
     * @param dept
     * @return 所有部门信息
     */
    @DataScope(deptAlias = "d")
    @Override
    public List<HrDept> selectDeptList(HrDept dept) {
     List<HrDept> deptList = hrDeptMapper.selectDeptList(dept);
        return deptList;
    }

    @Override
    public HrDept selectDeptById(Integer dId) {
      HrDept hrDept = hrDeptMapper.selectDeptById(dId);
        return hrDept;
    }

    /**
     * 查询部门管理树
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectDeptTree(HrDept dept) {
      List<HrDept> hrDeptList = hrDeptMapper.selectDeptList(dept);
        System.out.println("hrDeptList = " + hrDeptList);
        List<Ztree> ztrees = initZtree(hrDeptList);
        return ztrees;
    }

    /**
     * 校验部门名称是否可用
     * @param
     * @return
     */
    @Override
    public String checkDeptNameUnique(String deptName,Integer dPid) {
       HrDept hrDept = hrDeptMapper.selectDeptByNameAndPid(deptName,dPid);
        System.out.println("hrDept = " + hrDept);
        if (hrDept != null) {
            return "1";
        }
        return "0";
    }

    /**
     * 添加
     * @param dept
     * @param parentId
     * @return
     */
    @Override
    public int insertDept(HrDept dept,Integer parentId) {
      int row = hrDeptMapper.insertDept(dept,parentId);
        return row;
    }

    /**
     * 更新
     * @param hrDept
     * @return
     */
    @Override
    public int updateDept(HrDept hrDept) {
       int row = hrDeptMapper.updateDept(hrDept);
        return row;
    }

    @Override
    public int selectDeptCount(Long dId) {
      int count = hrDeptMapper.selectDeptCount(dId);
        return count;
    }

    @Override
    public boolean checkDeptExistUser(Long dId) {
       int count = hrDeptMapper.checkDeptExistUser(dId);
        System.out.println("count = " + count);
       if (count>0){
           return true;
       }
        return false;
    }

    @Override
    public boolean deleteDeptById(Long dId) {
      int row = hrDeptMapper.deleteDeptById(dId);
      if (row>=0){
          return true;
      }
        return false;
    }


    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     *
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<HrDept> deptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (HrDept dept : deptList)
        {

                Ztree ztree = new Ztree();
                ztree.setId(dept.getDId().longValue());
                ztree.setpId(dept.getDPid().longValue());
                ztree.setName(dept.getDeptName());
                ztree.setTitle(dept.getDeptName());
                ztrees.add(ztree);

        }
        return ztrees;
    }
}
