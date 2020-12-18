package com.ruoyi.project.system.task.mapper;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.task.domain.ExcelTask;
import com.ruoyi.project.system.task.domain.Selected;
import com.ruoyi.project.system.task.domain.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/14 21:56
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface TaskMapper {
    List<Task> selectTaskList(Task task);

    List<Ztree> selectEmpTree();

    Emp selectEmpById(Long empId);

    int addSave(Task task);

    Task selectTaskByTid(Integer tid);

    List<Selected> selectPrioritys();

    int editSave(Task task);

    int remove(@Param("ids") Integer[] ids);

    List<ExcelTask> selectExport(Task task);
}
