package com.ruoyi.project.system.schedule.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.schedule.service.IMyScheduleService;

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
 * @date 2020/12/16 19:29
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Controller
@RequestMapping("/system/schedule")
public class MyScheduleController extends BaseController {
    @Resource
    private IMyScheduleService myScheduleService;
    @Resource
    private ITaskApprovalService taskApprovalService;
    private String prefix = "system/schedule";
    @GetMapping()
    @RequiresPermissions("system:schedule:view")
    public String schedule(){
        return prefix+"/schedule";
    }
    @RequiresPermissions("system:schedule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaskApproval taskApproval) {
        User sysUser = getSysUser();
        startPage();
        List<TaskApproval> list = myScheduleService.selectScheduleList(taskApproval,sysUser.getUserId());
        return getDataTable(list);
    }
    @PostMapping("/edit")
    @ResponseBody
    @RequiresPermissions("system:schedule:edit")
    public AjaxResult editSave(TaskApproval task){
        return myScheduleService.editSave(task);
    }
    @RequiresPermissions("system:schedule:edit")
    @GetMapping("/edit/{tid}")
    public String edit(@PathVariable Integer tid, ModelMap map) {
        TaskApproval taskApproval = taskApprovalService.selectTaskApprovalByTid(tid);
        map.addAttribute("task",taskApproval);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.addAttribute("starttime",dateFormat.format(taskApproval.getStarttime()));
        map.addAttribute("endtime",dateFormat.format(taskApproval.getEndtime()));
        System.out.println(taskApproval);
        return prefix+"/edit";
    }
}
