package com.ruoyi.project.system.hr.dept.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.hr.dept.domain.HrDept;
import com.ruoyi.project.system.hr.dept.service.IHrDeptService;
import com.ruoyi.project.system.hr.emp.domain.Emp;
import com.ruoyi.project.system.hr.emp.vo.EmpVO;
import io.swagger.models.auth.In;
import net.bytebuddy.asm.Advice;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/15 10:23
 * 今天写完十万个Bug了吗？
 */
@Controller
@RequestMapping("/hr/dept")
public class HrDeptController extends BaseController {
    //定义前缀
    private String prefix = "hr/dept";
    @Autowired(required = false)
    private IHrDeptService iHrDeptService;

    /**
     * 部门页面跳转
     * @return 视图
     */
    @RequiresPermissions("hr:dept:view")
    @GetMapping()
    public String hrDept(){
    return prefix+"/dept";
}



    /**
     * 部门数据查询/展示
     * @param dept
     * @return HrDept
     */
    @RequiresPermissions("hr:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public List<HrDept> list(HrDept dept){
        List<HrDept> list = iHrDeptService.selectDeptList(dept);
        return list;
    }

    /**
     * 添加页面跳转
     * @return
     */
    @GetMapping("/add/{dPid}")
    public String AddView(@PathVariable Integer dPid, ModelMap mmap){
        mmap.put("dept", iHrDeptService.selectDeptById(dPid));
        return prefix+"/add";
    }

    /**
     * 添加部门
     * @param dept
     * @param parentId
     * @return
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("hr:dept:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated HrDept dept,Integer parentId)
    {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(iHrDeptService.checkDeptNameUnique(dept.getDeptName(),parentId)))
        {
            return error("新增部门'" + dept.getDeptName() + "'失败，部门名称已存在");
        }
        return toAjax(iHrDeptService.insertDept(dept,parentId));
    }


    /**
     * 修改页面跳转
     * @param dId
     * @param mmap
     * @return
     */
        @GetMapping("/edit/{dId}")
        public String editView(@PathVariable("dId") Integer dId ,ModelMap mmap){
            HrDept dept = iHrDeptService.selectDeptById(dId);
            if (StringUtils.isNotNull(dept) && 100 == dId)
            {
                dept.setParentName("无");
            }
            mmap.put("dept", dept);
            return prefix + "/edit";
        }

    /**
     * 部门更新
     * @param hrDept
     * @return AjaxResult
     */
    @RequiresPermissions("hr:dept:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult addSave(HrDept hrDept)
    {

      int row = iHrDeptService.updateDept(hrDept);
        if (row>=0){
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }
    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("hr:dept:remove")
    @GetMapping("/remove/{dId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("dId") Long dId)
    {
        if (iHrDeptService.selectDeptCount(dId) > 0)
        {
            return AjaxResult.warn("存在下级部门,不允许删除");
        }
        if (iHrDeptService.checkDeptExistUser(dId))
        {
            return AjaxResult.warn("部门存在用户,不允许删除");
        }
        return toAjax(iHrDeptService.deleteDeptById(dId));

    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{dId}")
    public String selectDeptTree(@PathVariable("dId") Integer dId, ModelMap mmap)
    {
        mmap.put("dept", iHrDeptService.selectDeptById(dId));
        System.out.println("dId = " + iHrDeptService.selectDeptById(dId).getDId());
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = iHrDeptService.selectDeptTree(new HrDept());
        System.out.println("ztrees = " + ztrees);
        return ztrees;
    }

}
