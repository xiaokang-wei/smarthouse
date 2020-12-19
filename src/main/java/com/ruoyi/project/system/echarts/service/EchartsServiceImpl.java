package com.ruoyi.project.system.echarts.service;


import com.ruoyi.project.system.echarts.mapper.EchartsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BUG KING
 * @date 2020/12/18 21:31
 * 今天的bug写完了吗?不努力怎么成为bug king
 */
@Service
public class EchartsServiceImpl implements IEchartsService{
    @Resource
    private EchartsMapper mapper;
    @Override
    public List<String> getData() {

        return mapper.getData1();
    }

    @Override
    public List<Integer> getData1() {
        return mapper.getData();
    }
}
