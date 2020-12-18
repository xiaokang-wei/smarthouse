package com.ruoyi.project.system.task.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.task.domain.ExcelTask;
import com.ruoyi.project.system.task.domain.Selected;
import com.ruoyi.project.system.task.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/14 21:38
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface ITaskService {

    List<Task> selectTaskList(Task task);

    List<Ztree> selectEmpTree();

    Emp selectEmpById(Long empId);

    AjaxResult addSave(Task task,String createBy);

    Task selectTaskByTid(Integer tid);

    List<Selected> selectPrioritys();

    AjaxResult editSave(Task task);

    boolean remove(Integer[] ids);

    List<ExcelTask> selectExport(Task task);
}
