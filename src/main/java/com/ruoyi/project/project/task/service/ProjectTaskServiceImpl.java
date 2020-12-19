package com.ruoyi.project.project.task.service;

import com.ruoyi.project.project.task.domain.Task1;
import com.ruoyi.project.project.task.mapper.ProjectTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskServiceImpl implements IProjectTaskService {

    @Autowired
    private ProjectTaskMapper projectTaskMapper;


    @Override
    public List<Task1> selectTaskAll() {
        return projectTaskMapper.selectTaskAll();
    }

    @Override
    public Task1 selecttaskDistributionById(int pid) {
        return projectTaskMapper.selecttaskDistributionById(pid);
    }


    @Override
    public int updateTask(Task1 task) {
        return projectTaskMapper.updateTask(task);
    }


//    @Override
//    public String checktaskContentNameUnique(Task task) {
//        int pid = StringUtils.isNull(pid.getPostId()) ? -1L : pid.getPostId();
//        Post info = postMapper.checkPostNameUnique(post.getPostName());
//        if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
//        {
//            return UserConstants.POST_NAME_NOT_UNIQUE;
//        }
//        return UserConstants.POST_NAME_UNIQUE;
//    }
}
