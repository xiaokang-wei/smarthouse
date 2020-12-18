package com.ruoyi.project.project.message.service;


import com.ruoyi.project.project.message.domain.Message;
import com.ruoyi.project.project.message.domain.ProjectMessage;

import java.util.List;

public interface IMessageService {

    /**
     * 查询项目信息集合
     *
     * @param
     * @return 项目信息集合
     */
    List<Message> selectMessageList(Message projectManager);

    /**
     * 查询所有项目信息
     *
     * @return 项目列表
     */
     List<Message> selectMessageAll();



    int insertProjectMessage(Message message);
}
