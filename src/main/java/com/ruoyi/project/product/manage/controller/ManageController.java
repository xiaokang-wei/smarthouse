package com.ruoyi.project.product.manage.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.manage.domain.ProManage;
import com.ruoyi.project.product.manage.service.ManageService;
import com.ruoyi.project.system.config.domain.Config;
import jdk.nashorn.internal.objects.Global;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Controller
@RequestMapping("/product/manage")
public class ManageController  extends BaseController{

        private String prefix = "product/manage";
        @Autowired
        private ManageService manageService;
        @RequiresPermissions("product:manage")
        @GetMapping()
        public String user()
        {
            return prefix + "/manage";
        }

        @RequiresPermissions("manage:list")
        @PostMapping("/list")
        @ResponseBody
        public TableDataInfo list(ProManage proManage)
        {
            System.out.println("======================");
            startPage();
            List<ProManage> list = manageService.selectSeriesList(proManage);
            System.out.println("list = " + list);
            return getDataTable(list);
        }

        //        删除
        @RequiresPermissions("manage:remove")
        @Log(title = "产品管理", businessType = BusinessType.DELETE)
        @PostMapping("/remove")
        @ResponseBody
        public AjaxResult remove(String ids)
        {
            try
            {
                return toAjax(manageService.deleteSeriesByIds(ids));
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
    @RequiresPermissions("manage:add")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProManage proManage)
    {
        return toAjax(manageService.insertSeries(proManage));
    }

    //检验是否唯一
    @PostMapping("/checkSeriesNameUnique")
    @ResponseBody
    public String checkPostNameUnique(ProManage proManage)
    {
        return manageService.checkSeriesNameUnique(proManage);
    }
    //编辑
    @GetMapping("/edit/{pdId}")
    public String edit(@PathVariable("pdId") int pdId, ModelMap mmap)
    {
        mmap.put("ProManage", manageService.selectSeriesById(pdId));
        return prefix + "/edit";
    }

    @RequiresPermissions("manage:edit")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave( ProManage proManage)
    {
        return toAjax(manageService.updateSeries(proManage));
    }

    //上传图片
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file)throws Exception{
        {
            try {
                //上传文件的路径
                String filePath= RuoYiConfig.getUploadPath();
                System.out.println("filePath = " + filePath);
                //上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url=ServerConfig.getUrl()+fileName;
                AjaxResult ajax = AjaxResult.success();
                ajax.put("fileName",fileName);
                ajax.put("url",url);
                System.out.println("=======================ajax = " + ajax);
                return ajax;

            }catch (Exception e){
                return AjaxResult.error(e.getMessage());
            }
        }
    }
//详细
@RequiresPermissions("manage:detail")
@GetMapping("/detail/{pdId}")
public String detail(@PathVariable("pdId") int pdId, ModelMap mmap)
{
    mmap.put("proManage", manageService.selectDetailById(pdId));
    return prefix + "/detail";
}


}
