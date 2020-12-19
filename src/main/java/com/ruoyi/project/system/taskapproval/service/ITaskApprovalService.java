package com.ruoyi.project.system.taskapproval.service;

import com.ruoyi.framework.web.domain.AjaxResult;

import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.taskapproval.domain.TaskApproval;


import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/16 10:29
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface ITaskApprovalService {
    List<TaskApproval> selectTaskApprovalList(TaskApproval taskApproval, User sysUser);

    TaskApproval selectTaskApprovalByTid(Integer tid);

    AjaxResult editSave(ReturnTask task);
}
