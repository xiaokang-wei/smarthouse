package com.ruoyi.project.system.echarts.domain;

import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 21:28
 * 今天的bug写完了吗?不努力怎么成为bug king
 */

public class Data {
    private List<String> names;
    private List<Integer> counts;
    public Data() {
    }
    public Data(List<String> names, List<Integer> counts) {
        this.names = names;
        this.counts = counts;
    }
    /**
     * 获取
     * @return names
     */
    public List<String> getNames() {
        return names;
    }

    /**
     * 设置
     * @param names
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * 获取
     * @return counts
     */
    public List<Integer> getCounts() {
        return counts;
    }

    /**
     * 设置
     * @param counts
     */
    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public String toString() {
        return "Data{names = " + names + ", counts = " + counts + "}";
    }
}
