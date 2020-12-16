package com.ruoyi.project.sell.user.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.sell.list.domain.SellList;
import com.ruoyi.project.sell.list.service.ISellListService;
import com.ruoyi.project.sell.user.domain.SellUser;
import com.ruoyi.project.sell.user.service.ISellUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//销售管理-客户管理
@Controller
@RequestMapping("/sell/user")
public class SellUserController extends BaseController {
    private String prefix = "sell/user";

    @Autowired
    private ISellUserService sellUserService;
    @Autowired
    private ISellListService sellListService;

    //跳转客户管理页面
    @RequiresPermissions("sell:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    //分页加载客户页面
    @RequiresPermissions("sell:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SellUser sellUser) {
        startPage();
        List<SellUser> list = sellUserService.selectUserList(sellUser);
        return getDataTable(list);
    }

    @ResponseBody
    @PostMapping("/sellList")
    public TableDataInfo findSellListById(String userName) {
        List<SellList> list = sellListService.selectSellListByName(userName);
        return getDataTable(list);
    }

    /**
     * 新增客户页面
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 校验客户手机号
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPostPhoneUnique(SellUser sellUser) {
        return sellUserService.checkPhoneUnique(sellUser);
    }

    /**
     * 新增保存客户
     */
    @RequiresPermissions("sell:user:add")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SellUser sellUser) {
        System.out.println(sellUser);
        if (UserConstants.Sell_USER_PHONE_NOT_UNIQUE.equals(sellUserService.checkPhoneUnique(sellUser))) {
            return error("新增客户'" + sellUser.getUserName() + "'失败，手机号码已存在");
        }

        return toAjax(sellUserService.insertUser(sellUser));
    }

    /**
     * 修改客户信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", sellUserService.selectUserById(userId));
        return prefix + "/edit";
    }

    /**
     * 修改保存客户信息
     */
    @RequiresPermissions("sell:user:edit")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SellUser sellUser) {
        if (UserConstants.Sell_USER_PHONE_NOT_UNIQUE.equals(sellUserService.checkPhoneUnique(sellUser))) {
            return error("修改客户信息'" + sellUser.getUserName() + "'失败，手机号已存在");
        }
        return toAjax(sellUserService.updateUser(sellUser));
    }

    /**
     * 删除公告类型
     */
    @RequiresPermissions("sell:user:remove")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(sellUserService.deleteUserByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}
