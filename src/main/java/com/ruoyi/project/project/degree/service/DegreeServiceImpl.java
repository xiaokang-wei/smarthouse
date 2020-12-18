package com.ruoyi.project.project.degree.service;


import com.ruoyi.project.project.degree.domain.Degree;
import com.ruoyi.project.project.degree.mapper.DegreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DegreeServiceImpl implements IDegreeService {

    @Autowired
    private DegreeMapper degreeMapper;

    @Override
    public List<Degree> selectDegreeAll() {
        return degreeMapper.selectDegreeAll();
    }
}
