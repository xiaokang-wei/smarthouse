package com.ruoyi.project.project.task.mapper;

import com.ruoyi.project.project.task.domain.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
    List<Task> selectTaskAll();

    Task selecttaskDistributionById(@Param("pid") int pid);

    String checktaskContentNameUnique(Task task);

    int updateTask(Task task);
}
