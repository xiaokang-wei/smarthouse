package com.ruoyi.project.product.style.controller;


import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.style.domain.ProStyle;
import com.ruoyi.project.product.style.service.StyleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/product/style")
public class StyleController extends BaseController{


        private String prefix = "product/style";
    @Autowired
    private StyleService styleService;
    @RequiresPermissions("product:style:manage")
    @GetMapping()
    public String user()
    {
        return prefix + "/style";
    }

    @RequiresPermissions("style:manage:list")
    @PostMapping("/list")
    @ResponseBody
        public TableDataInfo list(ProStyle proStyle)
        {
            System.out.println("======================");
            startPage();
            List<ProStyle> list = styleService.selectSeriesList(proStyle);
            System.out.println("list = " + list);
            return getDataTable(list);
        }

//        删除
        @RequiresPermissions("style:manage:remove")
        @Log(title = "产品资料管理", businessType = BusinessType.DELETE)
        @PostMapping("/remove")
        @ResponseBody
        public AjaxResult remove(String ids)
        {
            try
            {
                return toAjax(styleService.deleteSeriesByIds(ids));
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
        @RequiresPermissions("style:manage:add")
        @Log(title = "产品资料管理", businessType = BusinessType.INSERT)
        @PostMapping("/add")
        @ResponseBody
        public AjaxResult addSave(ProStyle proStyle)
        {
            return toAjax(styleService.insertSeries(proStyle));
        }

        //检验是否唯一
        @PostMapping("/checkSeriesNameUnique")
        @ResponseBody
        public String checkPostNameUnique(ProStyle proStyle)
        {
            return styleService.checkSeriesNameUnique(proStyle);
        }
    //编辑
    @GetMapping("/edit/{ppsId}")
    public String edit(@PathVariable("ppsId") int ppsId, ModelMap mmap)
    {
        mmap.put("ProStyle", styleService.selectSeriesById(ppsId));
        System.out.println("++++++++++++++++++++++++"+ styleService.selectSeriesById(ppsId));
        return prefix + "/edit";
    }

    @RequiresPermissions("style:manage:edit")
    @Log(title = "产品资料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave( ProStyle proStyle)
    {
        return toAjax(styleService.updateSeries(proStyle));
    }

}


