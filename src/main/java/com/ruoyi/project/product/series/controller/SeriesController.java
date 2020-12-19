package com.ruoyi.project.product.series.controller;


import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.series.domain.ProSeries;
import com.ruoyi.project.product.series.service.SeriesService;
import com.ruoyi.project.system.notice.domain.Notice;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/product/series")
public class SeriesController extends BaseController{


        private String prefix = "product/series";
    @Autowired
    private SeriesService seriesService;
    @RequiresPermissions("product:series:manage")
    @GetMapping()
    public String user()
    {
        return prefix + "/series";
    }

    @RequiresPermissions("series:manage:list")
    @PostMapping("/list")
    @ResponseBody
        public TableDataInfo list(ProSeries proSeries)
        {
            System.out.println("======================");
            startPage();
            List<ProSeries> list = seriesService.selectSeriesList(proSeries);
            System.out.println("list = " + list);
            return getDataTable(list);
        }

//        删除
        @RequiresPermissions("series:manage:remove")
        @Log(title = "产品资料管理", businessType = BusinessType.DELETE)
        @PostMapping("/remove")
        @ResponseBody
        public AjaxResult remove(String ids)
        {
            try
            {
                return toAjax(seriesService.deleteSeriesByIds(ids));
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
        @RequiresPermissions("series:manage:add")
        @Log(title = "产品资料管理", businessType = BusinessType.INSERT)
        @PostMapping("/add")
        @ResponseBody
        public AjaxResult addSave(ProSeries proSeries)
        {
            return toAjax(seriesService.insertSeries(proSeries));
        }

        //检验是否唯一
        @PostMapping("/checkSeriesNameUnique")
        @ResponseBody
        public String checkPostNameUnique(ProSeries proSeries)
        {
            return seriesService.checkSeriesNameUnique(proSeries);
        }
    //编辑
    @GetMapping("/edit/{ppsId}")
    public String edit(@PathVariable("ppsId") int ppsId, ModelMap mmap)
    {
        mmap.put("ProSeries", seriesService.selectSeriesById(ppsId));
        System.out.println("++++++++++++++++++++++++"+seriesService.selectSeriesById(ppsId));
        return prefix + "/edit";
    }

    @RequiresPermissions("series:manage:edit")
    @Log(title = "产品资料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave( ProSeries proSeries)
    {
        return toAjax(seriesService.updateSeries(proSeries));
    }

}


