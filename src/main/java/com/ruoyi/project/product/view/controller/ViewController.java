package com.ruoyi.project.product.view.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.manage.domain.ProManage;
import com.ruoyi.project.product.view.domain.ProView;
import com.ruoyi.project.product.view.service.ViewService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/product/view")
public class ViewController  extends BaseController {

    private String prefix = "product/view";
    @Autowired
    private ViewService viewService;

    @RequiresPermissions("product:view")
    @GetMapping()
    public String user() {
        return prefix + "/view";
    }

    @RequiresPermissions("manage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProView proView) {
        System.out.println("======================");
        startPage();
        List<ProView> list = viewService.selectSeriesList(proView);
        System.out.println("list = " + list);
        return getDataTable(list);

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
@RequiresPermissions("view:detail")
@GetMapping("/detail/{pdId}")
public String detail(@PathVariable("pdId") int pdId, ModelMap mmap)
{
    mmap.put("proView", viewService.selectDetailById(pdId));
    return prefix + "/detail";
}


}
