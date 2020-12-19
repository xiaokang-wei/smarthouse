package com.ruoyi.project.system.returntask.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.returntask.domain.ReturnTaskUp;


import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 15:42
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface IReturnTaskService {
    List<ReturnTask> list(ReturnTask returnTask, String loginName);

    AjaxResult editSave(ReturnTaskUp task);
}
