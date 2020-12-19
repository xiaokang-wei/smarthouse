package com.ruoyi.project.product.style.mapper;


import com.ruoyi.project.product.style.domain.ProStyle;

import java.util.List;

public interface StyleMapper {

    List<ProStyle> selectSeriesList(ProStyle proStyle);

//    public ProSeries selectSeriesById(Long ppsId);
    int deleteSeriesByIds(String[] ppsIds);

    int insertSeries(ProStyle proStyle);

    ProStyle checkSeriesNameUnique(String pName);

    int updateSeries(ProStyle proStyle);

    ProStyle selectSeriesById(int ppsId);
}
