package com.ruoyi.project.project.message.service;

import com.ruoyi.project.project.message.domain.Message;
import com.ruoyi.project.project.message.domain.ProjectMessage;
import com.ruoyi.project.project.message.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public List<Message> selectMessageList(Message projectManager) {
        return null;
    }

    @Override
    public List<Message> selectMessageAll() {
        return messageMapper.selectMessageAll();
    }


    @Override
    public int insertProjectMessage(Message message) {
        return messageMapper.insertProjectMessage(message);
    }


}
