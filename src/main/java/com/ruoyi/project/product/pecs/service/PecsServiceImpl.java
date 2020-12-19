package com.ruoyi.project.product.pecs.service;

import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.product.pecs.domain.ProPecs;
import com.ruoyi.project.product.pecs.mapper.PecsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PecsServiceImpl implements PecsService {
    @Autowired
    private PecsMapper pecsMapper;
    @Override
    public List<ProPecs> selectSeriesList(ProPecs proPecs) {
        return pecsMapper.selectSeriesList(proPecs);
    }
    @Override
    public int deleteSeriesByIds(String ids) {
        return pecsMapper.deleteSeriesByIds(Convert.toStrArray(ids));
    }

    @Override
    public int insertSeries(ProPecs proPecs) {
        return pecsMapper.insertSeries(proPecs);
    }

    @Override
    public String checkSeriesNameUnique(ProPecs proPecs) {
        Long ppsId = StringUtils.isNull(proPecs.getPpsId()) ? -1L : proPecs.getPpsId();
        ProPecs info = pecsMapper.checkSeriesNameUnique(proPecs.getPName());
        if (StringUtils.isNotNull(info) && info.getPpsId().longValue() != ppsId.longValue())
        {
            return SeriesConstants.SERIES_NAME_NOT_UNIQUE;
        }
        return SeriesConstants.SERIES_NAME_UNIQUE;
    }

    @Override
    public int updateSeries(ProPecs proPecs) {
        return pecsMapper.updateSeries(proPecs);
    }

    @Override
    public ProPecs selectSeriesById(int ppsId) {
        return pecsMapper.selectSeriesById(ppsId);
    }

}
