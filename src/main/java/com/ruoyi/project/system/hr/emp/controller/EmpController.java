package com.ruoyi.project.system.hr.emp.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.hr.dept.service.IHrDeptService;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.hr.emp.service.IEmpService;
import com.ruoyi.project.system.hr.emp.vo.EmpVO;
import com.ruoyi.project.system.user.domain.User;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/14 19:34
 * 今天写完十万个Bug了吗？
 */
@Controller
@RequestMapping("/hr/emp")
public class EmpController extends BaseController {
    //定义前缀
    private String prefix = "hr/emp";

    @Autowired(required = false)
    private IEmpService iEmpService;
    @Autowired
    private IHrDeptService iHrDeptService;

    /**
     * 页面展示跳转
     * @return String
     */
    @RequiresPermissions("hr:emp:view")
    @RequestMapping()
    public String emp(){
        return prefix+"/emp";
    }

    /**
     * 分页查询
     * @param emp
     * @return TableDataInfo
     */
    @RequiresPermissions("hr:emp:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Emp emp){
        startPage();
        List<EmpVO> list = iEmpService.selectEmpList(emp);
        return getDataTable(list);
    }

    /**
     * 雇员状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Emp emp)
    {
        return toAjax(iEmpService.changeStatus(emp));

    }

    /**
     * 添加页面跳转
     * @return String
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("posts", iEmpService.selectEmpList(null));
        mmap.put("empVOs",iEmpService.selectMgr());
        mmap.put("depts", iHrDeptService.selectDeptList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("hr:emp:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Emp emp,Integer eSex){
        if (eSex==0){
            emp.setESex("男");
        }else if (eSex==1){
            emp.setESex("女");
        }else {
            emp.setESex("未知");
        }
        //判断上级编号是否为空，若为空表示无上级，设置EmpNO为0；
        if (emp.getMgrNo()==null){
            emp.setMgrNo(0);
        }
        System.out.println("emp = " + emp);
        //查询最大的empNo,
       int empNo = iEmpService.selectMaxEmpNo();
        emp.setEmpNo(empNo+1);//每次添加自增1
        int row = iEmpService.insertEmp(emp);
        if (row>=0){
           return AjaxResult.success("添加成功");
        }
        return AjaxResult.success("添加失败");
    }

    /**
     * 修改页面跳转
     * @param mmmap
     * @return
     */
    @GetMapping("/edit/{eId}")
    public String edit(@PathVariable("eId") Integer eId, ModelMap mmmap) {
        mmmap.put("empVO", iEmpService.selectEmpListById(eId));
        System.out.println("empVO = " + iEmpService.selectEmpListById(eId));
        mmmap.put("post", iEmpService.selectPostList());
        List<Emp> list = iEmpService.selectPostList();
//        System.out.println(list);
        mmmap.put("empVOs",iEmpService.selectMgr());
        mmmap.put("depts", iHrDeptService.selectDeptList(null));
        return prefix + "/edit";
    }

    /**
     * 更新
     * @param emp
     * @param eSex
     * @return
     */
    @RequiresPermissions("hr:emp:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(Emp emp, Integer eSex){
        if (eSex==0){
            emp.setESex("男");
        }else if (eSex==1){
            emp.setESex("女");
        }else {
            emp.setESex("未知");
        }
        //判断上级编号是否为空，若为空表示无上级，设置EmpNO为0；
        if (emp.getMgrNo()==null){
            emp.setEmpNo(0);
        }
       List<Integer> list = iEmpService.selectByEmpNo(emp.getEmpNo());
        if (list.size() != 0) {
            return AjaxResult.error("有下属人员，不能直接修改");
        }
       int row = iEmpService.updateEmp(emp);
        if (row>=0){
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

    /**
     * 导出
     * @param empVo
     * @return
     */
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EmpVO empVo )
    {
        List<EmpVO> list = iEmpService.selectEmpList(empVo);
        ExcelUtil<EmpVO> util = new ExcelUtil<EmpVO>(EmpVO.class);
        return util.exportExcel(list, "用户数据");
    }



    @RequiresPermissions("hr:emp:remove")
    @RequestMapping("/remove")
    @ResponseBody
    public AjaxResult removeEmpById(String[] ids){
        System.out.println("eIds = " + ids.toString());
       List<Emp> empList = iEmpService.selectEmpByIds(ids);
        for (Emp emp : empList) {
            List<Integer> list = iEmpService.selectByEmpNo(emp.getEmpNo());
            if (list.size() != 0) {
                return AjaxResult.error("删除项中有下属人员，不能直接删除");
            }
        }
     int row  = iEmpService.removeEmpById(ids);
        if (row>=0){
            return AjaxResult.success("删除成功");
        }
        return AjaxResult.success("删除失败");
    }
}
