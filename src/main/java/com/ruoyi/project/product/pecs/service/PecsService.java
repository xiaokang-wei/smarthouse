package com.ruoyi.project.product.pecs.service;


import com.ruoyi.project.product.pecs.domain.ProPecs;

import java.util.List;

public interface PecsService {
    List<ProPecs> selectSeriesList(ProPecs proPecs);


    int deleteSeriesByIds(String ids);

    int insertSeries(ProPecs proPecs);

    public String checkSeriesNameUnique(ProPecs proPecs);

    int updateSeries(ProPecs proPecs);

    ProPecs selectSeriesById(int ppsId);
}
