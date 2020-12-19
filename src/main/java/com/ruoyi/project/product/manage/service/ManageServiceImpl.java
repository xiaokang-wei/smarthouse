package com.ruoyi.project.product.manage.service;

import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.product.manage.domain.ProManage;
import com.ruoyi.project.product.manage.mapper.ManageMapper;
import com.ruoyi.project.product.pecs.domain.ProPecs;
import com.ruoyi.project.product.pecs.mapper.PecsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManageServiceImpl implements ManageService{
    @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<ProManage> selectSeriesList(ProManage proManage) {
        return manageMapper.selectSeriesList(proManage);
    }

    @Override
    public int deleteSeriesByIds(String ids) {
        return manageMapper.deleteSeriesByIds(Convert.toStrArray(ids));
    }

    @Override
    public int insertSeries(ProManage proManage) {
        return manageMapper.insertSeries(proManage);
    }

    @Override
    public String checkSeriesNameUnique(ProManage proManage) {
        Long pdId = StringUtils.isNull(proManage.getPdId()) ? -1L : proManage.getPdId();
        ProManage info = manageMapper.checkSeriesNameUnique(proManage.getPdName());
        if (StringUtils.isNotNull(info) && info.getPdId().longValue() != pdId.longValue())
        {
            return SeriesConstants.SERIES_NAME_NOT_UNIQUE;
        }
        return SeriesConstants.SERIES_NAME_UNIQUE;
    }

    @Override
    public int updateSeries(ProManage proManage) {
        return manageMapper.updateSeries(proManage);
    }

    @Override
    public ProManage selectSeriesById(int pdId) {
        return manageMapper.selectSeriesById(pdId);
    }

    @Override
    public ProManage selectDetailById(int pdId) {
        return manageMapper.selectDetailById(pdId);
    }

}
