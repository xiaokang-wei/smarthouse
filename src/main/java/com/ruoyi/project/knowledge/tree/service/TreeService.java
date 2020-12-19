package com.ruoyi.project.knowledge.tree.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.hr.dept.domain.HrDept;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/15 20:54
 */
public interface TreeService {
    List<Ztree> selectDeptTree();

    HrDept selectDeptById(Integer deptId);
}
