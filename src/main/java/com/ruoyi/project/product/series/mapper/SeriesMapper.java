package com.ruoyi.project.product.series.mapper;


import com.ruoyi.project.product.series.domain.ProSeries;

import java.util.List;

public interface SeriesMapper {

    List<ProSeries> selectSeriesList(ProSeries proSeries);

//    public ProSeries selectSeriesById(Long ppsId);
    int deleteSeriesByIds(String[] ppsIds);

    int insertSeries(ProSeries proSeries);

    ProSeries checkSeriesNameUnique(String pName);

    int updateSeries(ProSeries proSeries);

    ProSeries selectSeriesById(int ppsId);
}
