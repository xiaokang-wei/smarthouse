package com.ruoyi.project.system.task.domain;

/**
 * @author BUG KING
 * @date 2020/12/15 19:35
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public class Selected {
    private String priority;
    private boolean flag;

    public Selected() {
    }

    public Selected(String priority, boolean flag) {
        this.priority = priority;
        this.flag = flag;
    }

    /**
     * 获取
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 设置
     * @param priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 获取
     * @return flag
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * 设置
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Selected{priority = " + priority + ", flag = " + flag + "}";
    }
}
