package com.ruoyi.project.knowledge.patent.controller;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

import com.ruoyi.project.knowledge.patent.domain.Patent;
import com.ruoyi.project.knowledge.patent.domain.PatentVO;
import com.ruoyi.project.knowledge.patent.service.IPatentService;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author wxk
 * @date 2020/12/14 21:38
 */
@Controller
@RequestMapping("/knowledge/patent")
public class PatentController extends BaseController{

        private String prefix = "knowledge/patent";

        @Autowired
        private IPatentService iPatentService;

        @RequiresPermissions("knowledge:patent:view")
        @GetMapping()
        public String operlog()
        {
            System.out.println(" 进来了-----------------------------------"  );
            return prefix + "/patent";
        }

        @RequiresPermissions("knowledge:patent:list")
        @PostMapping("/list")
        @ResponseBody
        public TableDataInfo list(PatentVO patentVO)
        {
            System.out.println("patent = " + patentVO);
            startPage();
            List<PatentVO> list = iPatentService.selectPatentVOList(patentVO);
            System.out.println("list = " + list);
            return getDataTable(list);
        }
        @RequiresPermissions("knowledge:patent:add")
        @GetMapping("/add")
        public String add()
        {
            return prefix + "/add";
        }

         @PostMapping("/checkPatentNameUnique")
         @ResponseBody
         public String checkPatentNameUnique(String patentName)
    {
        String s = iPatentService.checkPatentNameUnique(patentName);
        System.out.println("s = " + s);
        return iPatentService.checkPatentNameUnique(patentName);
    }

    /**
     * 新增保存
     */
    @RequiresPermissions("knowledge:patent:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(Patent patent)
    {
        String userName = getSysUser().getUserName();
        return iPatentService.insertPatent(patent,userName);
    }

    @GetMapping("/edit/{patentId}")
    public String selectNoticceTypeById(@PathVariable("patentId") Integer patentId, Model model)
    {
        PatentVO patent = iPatentService.selectPatentById(patentId);
        model.addAttribute("patent",patent);
        System.out.println("patent = " + patent);
        return prefix + "/edit";
    }
    @RequiresPermissions("knowledge:patent:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave( Patent patent)
    {
        System.out.println("patent = " + patent);
        String userName = getSysUser().getUserName();
        return iPatentService.updatePatentById(patent,userName);
    }
    @RequiresPermissions("knowledge:patent:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult deletePatentByIds(Integer[] ids) {
        return iPatentService.deletePatentById(ids);
    }

    @RequiresPermissions("knowledge:patent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PatentVO patentVO)
    {
        List<PatentVO> list = iPatentService.selectPatentVOList(patentVO);
        ExcelUtil<PatentVO> util = new ExcelUtil<>(PatentVO.class);
        return util.exportExcel(list, "专利数据");
    }
}
