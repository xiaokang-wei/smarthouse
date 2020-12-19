package com.ruoyi.project.project.check.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.project.check.domain.Check;
import com.ruoyi.project.project.check.service.ICheckService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project/check")
public class CheckController extends BaseController {

    private String prefix = "project/check";

    @Autowired
    private ICheckService checkService;

    @RequiresPermissions("project:check:view")
    @GetMapping()
    public String check()
    {
        return prefix + "/check";
    }

    @RequiresPermissions("project:check:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Check> list = checkService.selectCheckAll();
        return getDataTable(list);

    }

    //项目验收
    @GetMapping("/edit/{pid}")
    public String edit(@PathVariable("pid") int pid, ModelMap mmap)
    {
       mmap.put("check", checkService.selectprojectCheckById(pid));
        return prefix + "/projectCheck";
    }

    @RequiresPermissions("project:chek:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Check check)
    {

        return toAjax(checkService.updateCheck(check));
    }

}
