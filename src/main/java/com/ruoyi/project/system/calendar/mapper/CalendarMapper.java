package com.ruoyi.project.system.calendar.mapper;



import com.ruoyi.project.system.calendar.domain.Calendar;

import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/17 19:26
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public interface CalendarMapper {
    List<Calendar> selectCalendar(Long uid);
}
