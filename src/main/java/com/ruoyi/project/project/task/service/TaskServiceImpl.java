package com.ruoyi.project.project.task.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.project.task.domain.Task;
import com.ruoyi.project.project.task.mapper.TaskMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public List<Task> selectTaskAll() {
        return taskMapper.selectTaskAll();
    }

    @Override
    public Task selecttaskDistributionById(int pid) {
        return taskMapper.selecttaskDistributionById(pid);
    }


    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
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
