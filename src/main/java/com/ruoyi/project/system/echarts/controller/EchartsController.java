package com.ruoyi.project.system.echarts.controller;


import com.ruoyi.project.system.echarts.domain.Data;
import com.ruoyi.project.system.echarts.service.IEchartsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 21:09
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@RequestMapping("/system/echarts")
@Controller
public class EchartsController {
    private String prefix = "system/echarts";
    @Resource
    private IEchartsService echartsService;
    @GetMapping
    public String echarts(){
        return prefix+"/echarts";
    }
    @ResponseBody
    @GetMapping("/getData")
    public Data getData(){
        List<String> names=echartsService.getData();
        List<Integer> counts=echartsService.getData1();
        return new Data(names,counts);
    }
}
