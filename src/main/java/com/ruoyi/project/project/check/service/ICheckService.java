package com.ruoyi.project.project.check.service;


import com.ruoyi.project.project.check.domain.Check;
import com.ruoyi.project.project.degree.domain.Degree;

import java.util.List;

public interface ICheckService {


    List<Check> selectCheckAll();

    Check selectprojectCheckById(int pid);

    int updateCheck(Check check);
}
