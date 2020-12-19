package com.ruoyi.project.product.manage.service;

import com.ruoyi.project.product.manage.domain.ProManage;
import com.ruoyi.project.product.pecs.domain.ProPecs;

import java.util.List;

public interface ManageService {
    List<ProManage> selectSeriesList(ProManage proManage);

    int deleteSeriesByIds(String ids);

    int insertSeries(ProManage proManage);

    public String checkSeriesNameUnique(ProManage proManage);

    int updateSeries(ProManage proManage);

    ProManage selectSeriesById(int pdId);

    ProManage selectDetailById(int pdId);
}
