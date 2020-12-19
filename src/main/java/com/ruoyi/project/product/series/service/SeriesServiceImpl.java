package com.ruoyi.project.product.series.service;

import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.product.series.domain.ProSeries;
import com.ruoyi.project.product.series.mapper.SeriesMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeriesServiceImpl implements SeriesService {
    @Autowired
    private SeriesMapper seriesMapper;
    @Override
    public List<ProSeries> selectSeriesList(ProSeries proSeries) {
        return seriesMapper.selectSeriesList(proSeries);
    }
    @Override
    public int deleteSeriesByIds(String ids) {
        return seriesMapper.deleteSeriesByIds(Convert.toStrArray(ids));
    }

    @Override
    public int insertSeries(ProSeries proSeries) {
        return seriesMapper.insertSeries(proSeries);
    }

    @Override
    public String checkSeriesNameUnique(ProSeries proSeries) {
        Long ppsId = StringUtils.isNull(proSeries.getPpsId()) ? -1L : proSeries.getPpsId();
        ProSeries info = seriesMapper.checkSeriesNameUnique(proSeries.getPName());
        if (StringUtils.isNotNull(info) && info.getPpsId().longValue() != ppsId.longValue())
        {
            return SeriesConstants.SERIES_NAME_NOT_UNIQUE;
        }
        return SeriesConstants.SERIES_NAME_UNIQUE;
    }

    @Override
    public int updateSeries(ProSeries proSeries) {
        return seriesMapper.updateSeries(proSeries);
    }

    @Override
    public ProSeries selectSeriesById(int ppsId) {
        return seriesMapper.selectSeriesById(ppsId);
    }

}
