package com.ruoyi.project.system.calendar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author BUG KING
 * @date 2020/12/17 18:34
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public class Calendar {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String content;

    public Calendar() {
    }

    public Calendar(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    /**
     * 获取
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Calendar{date = " + date + ", content = " + content + "}";
    }
}
