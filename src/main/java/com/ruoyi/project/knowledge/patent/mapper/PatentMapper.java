package com.ruoyi.project.knowledge.patent.mapper;

import com.ruoyi.project.knowledge.patent.domain.Patent;
import com.ruoyi.project.knowledge.patent.domain.PatentVO;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/14 21:48
 */
public interface PatentMapper {
    List<PatentVO> selectPatentVOList(PatentVO patentVO);

    List<String> selectCondType();
    List<String> selectCondStatus();
    List<PatentVO> selectCondDName();

    Patent selectPatentByName(String patentName);

    Integer insertPatent(Patent patent);

    PatentVO selectPatentById(Integer patentId);

    Integer updatePatentById(Patent patent);

    Integer deletePatentById(Integer[] ids);
}
