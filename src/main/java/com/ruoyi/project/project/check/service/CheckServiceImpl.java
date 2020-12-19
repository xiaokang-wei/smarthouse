package com.ruoyi.project.project.check.service;


import com.ruoyi.project.project.check.domain.Check;
import com.ruoyi.project.project.check.mapper.CheckMapper;
import com.ruoyi.project.project.degree.domain.Degree;
import com.ruoyi.project.project.degree.mapper.DegreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CheckServiceImpl implements ICheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public List<Check> selectCheckAll() {
        return checkMapper.selectCheckAll();
    }

    @Override
    public Check selectprojectCheckById(int pid) {
        return checkMapper.selectprojectCheckById(pid);
    }

    @Override
    public int updateCheck(Check check) {
        return checkMapper.updateCheck(check);
    }
}
