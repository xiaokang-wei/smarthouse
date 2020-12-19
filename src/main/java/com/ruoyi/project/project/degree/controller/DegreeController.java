package com.ruoyi.project.project.degree.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.project.degree.domain.Degree;
import com.ruoyi.project.project.degree.service.IDegreeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project/degree")
class DegreeController extends BaseController {

    private String prefix = "project/degree";

    @Autowired
    private IDegreeService degreeService;

    @RequiresPermissions("project:degree:view")
    @GetMapping()
    public String degree()
    {
        return prefix + "/degree";
    }

    @RequiresPermissions("project:degree:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Degree> list = degreeService.selectDegreeAll();
        return getDataTable(list);

    }

    //项目进度查询
    @GetMapping("/edit/{pid}")
    public String edit(@PathVariable("pid") int pid, ModelMap mmap)
    {
       // mmap.put("degree", degreeService.selecttaskDistributionById(pid));
        return prefix + "/projectDegreeSeach";
    }

}
