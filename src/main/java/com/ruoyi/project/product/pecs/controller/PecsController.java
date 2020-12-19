package com.ruoyi.project.product.pecs.controller;


import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.pecs.domain.ProPecs;
import com.ruoyi.project.product.pecs.service.PecsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/product/pecs")
public class PecsController extends BaseController{


        private String prefix = "product/pecs";
    @Autowired
    private PecsService pecsService;
    @RequiresPermissions("product:pecs:manage")
    @GetMapping()
    public String user()
    {
        return prefix + "/pecs";
    }

    @RequiresPermissions("pecs:manage:list")
    @PostMapping("/list")
    @ResponseBody
        public TableDataInfo list(ProPecs proPecs)
        {
            System.out.println("======================");
            startPage();
            List<ProPecs> list = pecsService.selectSeriesList(proPecs);
            System.out.println("list = " + list);
            return getDataTable(list);
        }

//        删除
        @RequiresPermissions("pecs:manage:remove")
        @Log(title = "产品资料管理", businessType = BusinessType.DELETE)
        @PostMapping("/remove")
        @ResponseBody
        public AjaxResult remove(String ids)
        {
            try
            {
                return toAjax(pecsService.deleteSeriesByIds(ids));
            }
            catch (Exception e)
            {
                return error(e.getMessage());
            }
        }

        //添加
        @GetMapping("/add")
        public String add()
        {
            return prefix + "/add";
        }
        @RequiresPermissions("pecs:manage:add")
        @Log(title = "产品资料管理", businessType = BusinessType.INSERT)
        @PostMapping("/add")
        @ResponseBody
        public AjaxResult addSave(ProPecs proPecs)
        {
            return toAjax(pecsService.insertSeries(proPecs));
        }

        //检验是否唯一
        @PostMapping("/checkSeriesNameUnique")
        @ResponseBody
        public String checkPostNameUnique(ProPecs proPecs)
        {
            return pecsService.checkSeriesNameUnique(proPecs);
        }
    //编辑
    @GetMapping("/edit/{ppsId}")
    public String edit(@PathVariable("ppsId") int ppsId, ModelMap mmap)
    {
        mmap.put("ProPecs", pecsService.selectSeriesById(ppsId));
        System.out.println("++++++++++++++++++++++++"+ pecsService.selectSeriesById(ppsId));
        return prefix + "/edit";
    }

    @RequiresPermissions("pecs:manage:edit")
    @Log(title = "产品资料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave( ProPecs proPecs)
    {
        return toAjax(pecsService.updateSeries(proPecs));
    }

}


