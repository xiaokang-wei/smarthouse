package com.ruoyi.project.system.schedule.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.taskapproval.domain.TaskApproval;


import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/16 19:45
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface IMyScheduleService {
    List<TaskApproval> selectScheduleList(TaskApproval taskApproval, Long userId);

    AjaxResult editSave(TaskApproval task);
}
