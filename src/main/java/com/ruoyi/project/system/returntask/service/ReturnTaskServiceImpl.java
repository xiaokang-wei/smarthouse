package com.ruoyi.project.system.returntask.service;

import com.ruoyi.framework.web.domain.AjaxResult;

import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.returntask.domain.ReturnTaskUp;
import com.ruoyi.project.system.returntask.mapper.ReturnTaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 15:43
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Service
public class ReturnTaskServiceImpl implements IReturnTaskService{
    @Resource
    private ReturnTaskMapper mapper;
    @Override
    public List<ReturnTask> list(ReturnTask returnTask, String loginName) {

        return mapper.list(returnTask,loginName);
    }

    @Override
    public AjaxResult editSave(ReturnTaskUp task) {
        int row = mapper.editSave(task);
        if (row==1) {
            return AjaxResult.success("重新提交成功");
        }else {
            return AjaxResult.error("重新提交失败");
        }
    }
}
