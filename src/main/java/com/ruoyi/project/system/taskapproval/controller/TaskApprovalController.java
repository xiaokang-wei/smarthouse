package com.ruoyi.project.system.taskapproval.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

import com.ruoyi.project.system.returntask.domain.ReturnTask;

import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.taskapproval.domain.TaskApproval;
import com.ruoyi.project.system.taskapproval.service.ITaskApprovalService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/16 10:27
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Controller
@RequestMapping("/system/taskapproval")
public class TaskApprovalController extends BaseController {
    @Resource
    private ITaskApprovalService taskApprovalService;
    private String prefix = "system/taskapproval";
    @GetMapping
    @RequiresPermissions("system:taskapproval:view")
    public String taskApproval(){
        return prefix+"/taskapproval";
    }
    @RequiresPermissions("system:taskapproval:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaskApproval taskApproval) {
        startPage();
        User sysUser = getSysUser();
        List<TaskApproval> list = taskApprovalService.selectTaskApprovalList(taskApproval,sysUser);
        return getDataTable(list);
    }
    @RequiresPermissions("system:taskapproval:edit")
    @GetMapping("/edit/{tid}")
    public String edit(@PathVariable Integer tid, ModelMap map) {
        TaskApproval taskApproval = taskApprovalService.selectTaskApprovalByTid(tid);
        map.addAttribute("task",taskApproval);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.addAttribute("starttime",dateFormat.format(taskApproval.getStarttime()));
        map.addAttribute("endtime",dateFormat.format(taskApproval.getEndtime()));
//        System.out.println(taskApproval);
        return prefix+"/edit";
    }
    @PostMapping("/edit")
    @ResponseBody
    @RequiresPermissions("system:taskapproval:edit")
    public AjaxResult editSave(ReturnTask task){
        System.out.println(task);
        User sysUser = getSysUser();
        if(task.getExamine()!=0){
            task.setReviewer(sysUser.getLoginName());
        }
        return taskApprovalService.editSave(task);
    }

}
