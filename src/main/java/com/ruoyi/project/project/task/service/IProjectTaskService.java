package com.ruoyi.project.project.task.service;

import com.ruoyi.project.project.task.domain.Task1;

import java.util.List;

public interface IProjectTaskService {



    //查看所有
    List<Task1> selectTaskAll();

    //任务分配
    Task1 selecttaskDistributionById(int pid);

    int updateTask(Task1 task);


//    String checktaskContentNameUnique(Task task);
}
