package com.ruoyi.project.sell.list.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.sell.list.domain.SellList;
import com.ruoyi.project.sell.list.service.ISellListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sell/list")
public class SellListController extends BaseController {
    //声明资源地址的公共前缀
    private String prefix = "sell/list";

    @Autowired
    private ISellListService sellListService;

    //声明单元方法:跳转公告类型管理页面
    @RequiresPermissions("sell:list:view")
    @GetMapping()
    public String sellList(){
        return prefix+"/list";
    }

    //分页加载订单页面
    @RequiresPermissions("sell:list:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SellList sellList)
    {
        startPage();
        List<SellList> list = sellListService.selectSellList(sellList);
        return getDataTable(list);
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 订单唯一性校验
     */
    @PostMapping("/checkSellListNameUnique")
    @ResponseBody
    public String checkSellListNameUnique(SellList sellList)
    {
        return sellListService.checkSellListNameUnique(sellList);
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("sell:list:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SellList sellList)
    {
        if (UserConstants.SELL_LIST_NAME_NOT_UNIQUE.equals(sellListService.checkSellListNameUnique(sellList)))
        {
            return error("新增订单'" + sellList.getListName() + "'失败，订单已存在");
        }

        return toAjax(sellListService.insertSellList(sellList));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("sell:list:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(sellListService.deleteSellListByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{listId}")
    public String edit(@PathVariable("listId") Long listId, ModelMap mmap)
    {
        mmap.put("list", sellListService.selectSellListById(listId));
        return prefix + "/edit";
    }
    /**
     * 修改保存订单
     */
    @RequiresPermissions("sell:list:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SellList sellList)
    {
        if (UserConstants.SELL_LIST_NAME_NOT_UNIQUE.equals(sellListService.checkSellListNameUnique(sellList)))
        {
            return error("修改订单'" + sellList.getListName()+ "'失败，订单名称已存在");
        }
        return toAjax(sellListService.updateSellList(sellList));
    }
}
