package com.ruoyi.project.system.hr.recr.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.hr.emp.vo.EmpVO;
import com.ruoyi.project.system.hr.recr.domain.Recr;
import com.ruoyi.project.system.hr.recr.service.IRecrService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/17 16:00
 * 今天写完十万个Bug了吗？
 */
@Controller
@RequestMapping("/hr/recr")
public class RecrController extends BaseController {
    //定义前缀
    private String prefix = "hr/recr";
    @Autowired
    private IRecrService iRecrService;

    @RequiresPermissions("he:recr:view")
    @GetMapping()
    public String recrView(ModelMap modelMap){
       List<Recr> list = iRecrService.selectRecrList(null);
//        System.out.println("list = " + list);
        modelMap.put("recr",list);
        return prefix+"/recr";
    }

    /**
     * 分页查询
     * @param recr
     * @return
     */
    @RequiresPermissions("he:recr:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo selectRecrList(Recr recr){
        startPage();
        System.out.println("time = " +  recr.getCreatTime());
        List<Recr> recrList = iRecrService.selectRecrList(recr);
        return getDataTable(recrList);
    }

    /**
     * 添加页面跳转
     * @param modelMap
     * @return
     */
    @RequiresPermissions("he:recr:add")
    @GetMapping("/add")
    public String recrAdd(ModelMap modelMap){

        return prefix+"/add";
    }

    /**
     * 添加数据
     * @param recr
     * @return
     */
    @RequiresPermissions("he:recr:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addRecr(Recr recr){
        return toAjax(iRecrService.addRecr(recr));
    }

    /**
     * 修改页面跳转 回写
     * @param rid
     * @param modelMap
     * @return
     */
    @RequiresPermissions("hr:recr:edit")
    @GetMapping("/edit/{rid}")
    public String recrEdit(@PathVariable("rid")Integer rid, ModelMap modelMap){
      Recr recr = iRecrService.selectRecrById(rid);
      List<String> stringList = iRecrService.selectRecrForApproStatus();
        modelMap.put("ApproStatus",stringList);
        modelMap.put("recr",recr);
        return prefix+"/edit";
    }

    /**
     * 更新数据
     * @param recr
     * @return
     */
    @RequiresPermissions("he:recr:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editRecr(Recr recr){

        return toAjax(iRecrService.editRecrById(recr));
    }

    /**
     * 删除数据
     * @param ids
     * @return
     */
    @RequiresPermissions("he:recr:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult removeRecr(String[] ids){

        return iRecrService.removeRecrByIds(ids);
    }

    /**
     * 导出
     * @param recr
     * @return
     */
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("hr:recr:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Recr recr )
    {
        List<Recr> list = iRecrService.selectRecrList(recr);
        ExcelUtil<Recr> util = new ExcelUtil<Recr>(Recr.class);
        return util.exportExcel(list, "用户数据");
    }
}
