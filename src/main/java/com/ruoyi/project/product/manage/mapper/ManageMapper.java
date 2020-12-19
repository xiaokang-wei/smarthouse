package com.ruoyi.project.product.manage.mapper;

import com.ruoyi.project.product.manage.domain.ProManage;
import com.ruoyi.project.product.pecs.domain.ProPecs;

import java.util.List;

public interface ManageMapper {
    public List<ProManage> selectSeriesList(ProManage  proManage);

    int deleteSeriesByIds(String[] pdIds);

    int insertSeries(ProManage proManage);


    int updateSeries(ProManage proManage);

    ProManage selectSeriesById(int pdId);

    ProManage checkSeriesNameUnique(String pdName);

    ProManage selectDetailById(int pdId);
}
