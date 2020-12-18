package com.ruoyi.project.system.returntask.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

import com.ruoyi.project.system.returntask.domain.ReturnTask;
import com.ruoyi.project.system.returntask.domain.ReturnTaskUp;
import com.ruoyi.project.system.returntask.service.IReturnTaskService;
import com.ruoyi.project.system.task.domain.Selected;
import com.ruoyi.project.system.task.domain.Task;
import com.ruoyi.project.system.task.service.ITaskService;

import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 15:40
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Controller
@RequestMapping("/system/returntask")
public class ReturnTaskController extends BaseController {
    @Resource
    private IReturnTaskService returnTaskService;
    @Resource
    private ITaskService taskService;
    private String prefix = "system/returntask";
    @GetMapping
    @RequiresPermissions("system:returntask:view")
    public String returnTask(){
        return prefix+"/returntask";
    }
    @RequiresPermissions("system:returntask:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ReturnTask returnTask){
        User sysUser = getSysUser();
        return getDataTable(returnTaskService.list(returnTask,sysUser.getLoginName()));
    }
    @GetMapping("/edit/{tid}")
    @RequiresPermissions("system:returntask:edit")
    public String edit(@PathVariable Integer tid, ModelMap map){
        Task task=taskService.selectTaskByTid(tid);
        List<Selected> selecteds=taskService.selectPrioritys();
        for (int i = 0; i < selecteds.size(); i++) {
            if(selecteds.get(i).getPriority().equals(task.getPriority())){
                selecteds.get(i).setFlag(true);
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.addAttribute("starttime",dateFormat.format(task.getStarttime()));
        map.addAttribute("endtime",dateFormat.format(task.getEndtime()));
        map.addAttribute("task",task);
        map.addAttribute("selecteds",selecteds);
        return prefix+"/edit";
    }
    @PostMapping("/edit")
    @ResponseBody
    @RequiresPermissions("system:returntask:edit")
    public AjaxResult editSave(ReturnTaskUp task){
        task.setReviewer("");
        task.setT_content("");
        task.setExamine(0);
        return returnTaskService.editSave(task);
    }

}
