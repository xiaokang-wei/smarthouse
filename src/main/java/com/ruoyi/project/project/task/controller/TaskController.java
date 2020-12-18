package com.ruoyi.project.project.task.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.project.task.domain.Task;
import com.ruoyi.project.project.task.service.ITaskService;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project/task")
public class TaskController extends BaseController {

    private String prefix = "project/task";

    @Autowired
    private ITaskService taskService;

    @RequiresPermissions("project:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    @RequiresPermissions("project:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Task> list = taskService.selectTaskAll();
        return getDataTable(list);

    }

    //项目任务分配
    @GetMapping("/edit/{pid}")
    public String edit(@PathVariable("pid") int pid, ModelMap mmap)
    {
        mmap.put("task", taskService.selecttaskDistributionById(pid));
        return prefix + "/distribution";
    }

    @RequiresPermissions("project:task:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Task task)
    {

        return toAjax(taskService.updateTask(task));
    }


    /**
     * 校验项目任务
     */
    @PostMapping("/checktaskContentNameUnique")
    @ResponseBody
    public String checktaskContentNameUnique(Task task)
    {
        return null;
//        taskService.checktaskContentNameUnique(task);
    }

}
