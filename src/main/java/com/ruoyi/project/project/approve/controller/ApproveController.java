package com.ruoyi.project.project.approve.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.project.approve.domain.Approve;
import com.ruoyi.project.project.approve.service.IApproveService;
import com.ruoyi.project.project.check.domain.Check;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project/approve")
public class ApproveController extends BaseController {

    private String prefix = "project/approve";

    @Autowired
    private IApproveService approveService;

    @RequiresPermissions("project:approve:view")
    @GetMapping()
    public String approve()
    {
        return prefix + "/approve";
    }


    @RequiresPermissions("project:approve:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Approve> list = approveService.selectApproveAll();
        return getDataTable(list);

    }

    //项目验收
    @GetMapping("/edit/{pid}")
    public String edit(@PathVariable("pid") int pid, ModelMap mmap)
    {
        mmap.put("approve", approveService.selectprojectApproveById(pid));
        return prefix + "/projectApprove";
    }

    @RequiresPermissions("project:approve:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Approve approve)
    {

        return toAjax(approveService.updateApprove(approve));
    }
}
