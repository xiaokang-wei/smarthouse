package com.ruoyi.project.product.series.service;


import com.ruoyi.project.product.series.domain.ProSeries;
import com.ruoyi.project.system.post.domain.Post;


import java.util.List;

public interface SeriesService {
    List<ProSeries> selectSeriesList(ProSeries proSeries);


    int deleteSeriesByIds(String ids);

    int insertSeries(ProSeries proSeries);

    public String checkSeriesNameUnique(ProSeries proSeries);

    int updateSeries(ProSeries proSeries);

    ProSeries selectSeriesById(int ppsId);
}
