package com.ruoyi.project.project.check.mapper;

import com.ruoyi.project.project.check.domain.Check;
import com.ruoyi.project.project.degree.domain.Degree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckMapper {

    List<Check> selectCheckAll();

    Check selectprojectCheckById(int pid);

    int updateCheck(Check check);
}
