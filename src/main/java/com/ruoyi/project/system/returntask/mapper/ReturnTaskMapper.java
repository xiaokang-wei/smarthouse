package com.ruoyi.project.system.returntask.mapper;

import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.returntask.domain.ReturnTaskUp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 15:43
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface ReturnTaskMapper {
    List<ReturnTask> list(@Param("returnTask") ReturnTask returnTask, @Param("name") String loginName);

    int editSave(ReturnTaskUp task);
}
