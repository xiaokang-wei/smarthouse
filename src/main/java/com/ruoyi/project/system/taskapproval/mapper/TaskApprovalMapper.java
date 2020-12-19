package com.ruoyi.project.system.taskapproval.mapper;

import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.taskapproval.domain.TaskApproval;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/16 10:30
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface TaskApprovalMapper {
    List<TaskApproval> selectTaskApprovalList(@Param("taskApproval") TaskApproval taskApproval, @Param("userId") Long userId);

    TaskApproval selectTaskApprovalByTid(Integer tid);

    int editSave(ReturnTask task);

    List<TaskApproval> selectScheduleList(@Param("taskApproval") TaskApproval taskApproval, @Param("userId") Long userId);

    int editSave1(TaskApproval task);
}
