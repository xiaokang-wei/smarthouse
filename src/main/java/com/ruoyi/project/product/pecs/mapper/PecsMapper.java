package com.ruoyi.project.product.pecs.mapper;



import com.ruoyi.project.product.pecs.domain.ProPecs;

import java.util.List;

public interface PecsMapper {

    List<ProPecs> selectSeriesList(ProPecs proPecs);

//    public ProSeries selectSeriesById(Long ppsId);
    int deleteSeriesByIds(String[] ppsIds);

    int insertSeries(ProPecs proPecs);

    ProPecs checkSeriesNameUnique(String pName);

    int updateSeries(ProPecs proPecs);

    ProPecs selectSeriesById(int ppsId);
}
