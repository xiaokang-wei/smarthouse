package com.ruoyi.project.project.task.mapper;

import com.ruoyi.project.project.task.domain.Task1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskMapper {
    List<Task1> selectTaskAll();

    Task1 selecttaskDistributionById(@Param("pid") int pid);

    String checktaskContentNameUnique(Task1 task);

    int updateTask(Task1 task);
}
