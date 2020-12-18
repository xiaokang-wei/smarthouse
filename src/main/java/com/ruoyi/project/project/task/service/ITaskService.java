package com.ruoyi.project.project.task.service;

import com.ruoyi.project.project.task.domain.Task;

import java.util.List;

public interface ITaskService {



    //查看所有
    List<Task> selectTaskAll();

    //任务分配
    Task selecttaskDistributionById(int pid);

    int updateTask(Task task);


//    String checktaskContentNameUnique(Task task);
}
