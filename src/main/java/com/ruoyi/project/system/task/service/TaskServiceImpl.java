package com.ruoyi.project.system.task.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.task.domain.ExcelTask;
import com.ruoyi.project.system.task.domain.Selected;
import com.ruoyi.project.system.task.domain.Task;
import com.ruoyi.project.system.task.mapper.TaskMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/14 21:56
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Service
public class TaskServiceImpl implements ITaskService{
    @Resource
    private TaskMapper taskMapper;
    @Override
    public List<Task> selectTaskList(Task task) {
        List<Task> tasks=taskMapper.selectTaskList(task);
        return tasks;
    }

    @Override
    public List<Ztree> selectEmpTree() {
        return taskMapper.selectEmpTree();
    }

    @Override
    public Emp selectEmpById(Long empId) {
        return taskMapper.selectEmpById(empId);
    }

    @Override
    public AjaxResult addSave(Task task,String createBy) {
        task.setCreatby(createBy);
        int row=taskMapper.addSave(task);
        if(row==1){
            return AjaxResult.success("添加成功");
        }else {
            return AjaxResult.error("添加失败");
        }

    }

    @Override
    public Task selectTaskByTid(Integer tid) {
        Task task=taskMapper.selectTaskByTid(tid);
        return task;
    }

    @Override
    public List<Selected> selectPrioritys() {

        return taskMapper.selectPrioritys();
    }

    @Override
    public AjaxResult editSave(Task task) {
        int row=taskMapper.editSave(task);
        if (row==1) {
            return AjaxResult.success("修改成功");
        }else {
           return AjaxResult.error("修改失败");
        }
    }

    @Override
    public boolean remove(Integer[] ids) {
        int row=taskMapper.remove(ids);
        if(row==ids.length){
            return true;
        }else {
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public List<ExcelTask> selectExport(Task task) {
        return taskMapper.selectExport(task);
    }
}
