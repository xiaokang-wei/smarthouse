package com.ruoyi.project.knowledge.tree.controller;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.knowledge.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/15 20:50
 */
@Controller
@RequestMapping("/knowledge/tree")
public class TreeController {
    @Autowired
    private TreeService treeService;


    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Integer deptId, ModelMap mmap)
    {
        mmap.put("dept", treeService.selectDeptById(deptId));
        return  "knowledge/patent/tree";
    }

    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = treeService.selectDeptTree();
        return ztrees;
    }

}
