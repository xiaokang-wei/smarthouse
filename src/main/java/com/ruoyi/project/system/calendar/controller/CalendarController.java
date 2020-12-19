package com.ruoyi.project.system.calendar.controller;

import com.ruoyi.framework.web.controller.BaseController;


import com.ruoyi.project.system.calendar.domain.Calendar;
import com.ruoyi.project.system.calendar.service.ICalendarService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/17 16:51
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Controller
@RequestMapping("/system/calendar")
public class CalendarController extends BaseController {
    private String prefix = "system/calendar";
    @Resource
    private ICalendarService calendarService;
    @GetMapping
    @RequiresPermissions("system:calendar:view")
    public String calendar(){
        return prefix+"/calendar";
    }
    @PostMapping("/getCalendar")
    @RequiresPermissions("system:calendar:getCalendar")
    @ResponseBody
    public List<Calendar> getCalendar(){
        User sysUser = getSysUser();
        List<Calendar> calendars=calendarService.selectCalendar(sysUser.getUserId());
        System.out.println(calendars);
        return calendars;
    }
}
