package com.ruoyi.project.project.degree.mapper;

import com.ruoyi.project.project.degree.domain.Degree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeMapper {

    List<Degree> selectDegreeAll();

}
