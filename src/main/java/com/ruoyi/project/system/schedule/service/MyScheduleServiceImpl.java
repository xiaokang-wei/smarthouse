package com.ruoyi.project.system.schedule.service;


import com.ruoyi.framework.web.domain.AjaxResult;

import com.ruoyi.project.system.taskapproval.domain.TaskApproval;
import com.ruoyi.project.system.taskapproval.mapper.TaskApprovalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/16 19:45
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Service
public class MyScheduleServiceImpl implements IMyScheduleService{
    @Resource
    private TaskApprovalMapper taskApprovalMapper;
    @Override
    public List<TaskApproval> selectScheduleList(TaskApproval taskApproval, Long userId) {
        List<TaskApproval> taskApprovals=taskApprovalMapper.selectScheduleList(taskApproval,userId);
        return taskApprovals;
    }

    @Override
    public AjaxResult editSave(TaskApproval task) {
        int row=taskApprovalMapper.editSave1(task);
        if (row==1) {
            return AjaxResult.success("更改任务状态成功");
        }else {
            return AjaxResult.error("更改任务状态成功");
        }
    }
}
