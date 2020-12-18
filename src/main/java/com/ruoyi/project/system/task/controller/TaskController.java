package com.ruoyi.project.system.task.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.framework.web.page.TableDataInfo;


import com.ruoyi.project.system.post.domain.Post;
import com.ruoyi.project.system.task.domain.ExcelTask;
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
 * @date 2020/12/14 21:05
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Controller
@RequestMapping("/system/task")
public class TaskController extends BaseController {
    @Resource
    private ITaskService taskService;
    private String prefix = "system/task";
    @RequiresPermissions("system:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }
    @RequiresPermissions("system:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Task task)
    {
        startPage();
        List<Task> list = taskService.selectTaskList(task);
        return getDataTable(list);
    }
    @GetMapping("/add")
    @RequiresPermissions("system:task:add")
    public String add(){
        return prefix+"/add";
    }
    @GetMapping("/selectEmpTree")
    public String selectDeptTree() {
        return prefix + "/tree";
    }
    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = taskService.selectEmpTree();
        return ztrees;
    }

    @RequiresPermissions("system:task:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Task task){
        User sysUser = getSysUser();
        task.setExstatus("未开始");
        System.out.println(task);
        return taskService.addSave(task,sysUser.getLoginName());
    }
    @GetMapping("/edit/{tid}")
    @RequiresPermissions("system:task:edit")
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
    @RequiresPermissions("system:task:edit")
    public AjaxResult editSave(Task task){
        return taskService.editSave(task);
    }
    @PostMapping("/remove")
    @RequiresPermissions("system:task:remove")
    @ResponseBody
    public AjaxResult remove(Integer[] ids){
        boolean flag=taskService.remove(ids);
        if (flag) {
            return AjaxResult.success("删除成功");
        }else {
            return AjaxResult.error("删除失败");
        }
    }
    @RequiresPermissions("system:task:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Task task)
    {
        startPage();
        List<ExcelTask> tasks=taskService.selectExport(task);
        ExcelUtil<ExcelTask> util = new ExcelUtil<ExcelTask>(ExcelTask.class);
        return util.exportExcel(tasks,"任务数据");
    }
}
