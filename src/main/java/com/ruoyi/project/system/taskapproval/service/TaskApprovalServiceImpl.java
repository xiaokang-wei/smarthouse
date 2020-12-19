package com.ruoyi.project.system.taskapproval.service;

import com.ruoyi.framework.web.domain.AjaxResult;

import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.taskapproval.domain.TaskApproval;
import com.ruoyi.project.system.taskapproval.mapper.TaskApprovalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/16 10:30
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Service
public class TaskApprovalServiceImpl implements ITaskApprovalService{
    @Resource
    private TaskApprovalMapper mapper;
    @Override
    public List<TaskApproval> selectTaskApprovalList(TaskApproval taskApproval, User sysUser) {
        return mapper.selectTaskApprovalList(taskApproval,sysUser.getUserId());
    }


    @Override
    public TaskApproval selectTaskApprovalByTid(Integer tid) {
        return mapper.selectTaskApprovalByTid(tid);
    }

    @Override
    public AjaxResult editSave(ReturnTask task) {
        int row=mapper.editSave(task);
        if (row==1) {
            return AjaxResult.success("审批成功");
        }else {
            return AjaxResult.error("审批失败");
        }

    }
}
