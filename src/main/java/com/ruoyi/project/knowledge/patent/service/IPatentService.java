package com.ruoyi.project.knowledge.patent.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.knowledge.patent.domain.Patent;
import com.ruoyi.project.knowledge.patent.domain.PatentVO;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/14 21:48
 */
public interface IPatentService {
    List<PatentVO> selectPatentVOList(PatentVO patentVO);

    String checkPatentNameUnique(String typeName);

    AjaxResult insertPatent(Patent patent, String userName  );

    PatentVO selectPatentById(Integer patentId);


    AjaxResult updatePatentById(Patent patent, String userName);

    AjaxResult deletePatentById(Integer[] ids);

}
