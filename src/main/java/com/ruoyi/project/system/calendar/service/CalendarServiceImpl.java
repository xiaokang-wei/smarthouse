package com.ruoyi.project.system.calendar.service;


import com.ruoyi.project.system.calendar.domain.Calendar;
import com.ruoyi.project.system.calendar.mapper.CalendarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/17 19:26
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Service
public class CalendarServiceImpl implements ICalendarService{
    @Resource
    private CalendarMapper mapper;
    @Override
    public List<Calendar> selectCalendar(Long uid) {
        return mapper.selectCalendar(uid);
    }
}
