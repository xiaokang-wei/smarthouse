package com.ruoyi.project.product.show.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.show.domain.ProShow;
import com.ruoyi.project.product.show.service.ShowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/product/show")
public class ShowController  extends BaseController{

        private String prefix = "product/show";
        @Autowired
        private ShowService showService;
        @RequiresPermissions("product:show")
        @GetMapping()
        public String user()
        {
            return prefix + "/show";
        }

        @RequiresPermissions("show:list")
        @PostMapping("/list")
        @ResponseBody
        public TableDataInfo list(ProShow proShow)
        {
            System.out.println("======================");
            startPage();
            List<ProShow> list = showService.selectSeriesList(proShow);
            System.out.println("list = " + list);
            return getDataTable(list);
        }

        //        删除
        @RequiresPermissions("show:remove")
        @Log(title = "产品展示管理", businessType = BusinessType.DELETE)
        @PostMapping("/remove")
        @ResponseBody
        public AjaxResult remove(String ids)
        {
            try
            {
                return toAjax(showService.deleteSeriesByIds(ids));
            }
            catch (Exception e)
            {
                return error(e.getMessage());
            }
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
@RequiresPermissions("show:detail")
@GetMapping("/detail/{pdId}")
public String detail(@PathVariable("pdId") int pdId, ModelMap mmap)
{
    mmap.put("proShow", showService.selectDetailById(pdId));
    return prefix + "/detail";
}


}
