package com.ruoyi.project.project.message.mapper;

import com.ruoyi.project.project.message.domain.Message;
import com.ruoyi.project.project.message.domain.ProjectMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    //查询所有项目信息
    List<Message> selectMessageAll();

    int insertProjectMessage(Message message);

}
