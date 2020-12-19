package com.ruoyi.project.project.message.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.project.message.domain.Message;
import com.ruoyi.project.project.message.domain.ProjectMessage;
import com.ruoyi.project.project.message.service.IMessageService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project/message")
public class MessageController extends BaseController {

    private String prefix = "project/message";

    @Autowired
    private IMessageService messageService;


    @RequiresPermissions("project:message:view")
    @GetMapping()
    public String message()
    {
        return prefix + "/message";
    }


    @RequiresPermissions("project:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Message> list = messageService.selectMessageAll();
        return getDataTable(list);

    }


    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("message", messageService.selectMessageAll());
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("project:message:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Message message)
    {
        return toAjax(messageService.insertProjectMessage(message));
    }


}
