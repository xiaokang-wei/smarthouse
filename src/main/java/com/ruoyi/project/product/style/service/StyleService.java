package com.ruoyi.project.product.style.service;


import com.ruoyi.project.product.style.domain.ProStyle;

import java.util.List;

public interface StyleService {
    List<ProStyle> selectSeriesList(ProStyle proStyle);


    int deleteSeriesByIds(String ids);

    int insertSeries(ProStyle proStyle);

    public String checkSeriesNameUnique(ProStyle proStyle);

    int updateSeries(ProStyle proStyle);

    ProStyle selectSeriesById(int ppsId);
}
