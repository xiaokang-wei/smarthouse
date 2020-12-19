package com.ruoyi.project.product.style.service;

import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.product.style.domain.ProStyle;
import com.ruoyi.project.product.style.mapper.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {
    @Autowired
    private StyleMapper styleMapper;
    @Override
    public List<ProStyle> selectSeriesList(ProStyle proStyle) {
        return styleMapper.selectSeriesList(proStyle);
    }
    @Override
    public int deleteSeriesByIds(String ids) {
        return styleMapper.deleteSeriesByIds(Convert.toStrArray(ids));
    }

    @Override
    public int insertSeries(ProStyle proStyle) {
        return styleMapper.insertSeries(proStyle);
    }

    @Override
    public String checkSeriesNameUnique(ProStyle proStyle) {
        Long ppsId = StringUtils.isNull(proStyle.getPpsId()) ? -1L : proStyle.getPpsId();
        ProStyle info = styleMapper.checkSeriesNameUnique(proStyle.getPName());
        if (StringUtils.isNotNull(info) && info.getPpsId().longValue() != ppsId.longValue())
        {
            return SeriesConstants.SERIES_NAME_NOT_UNIQUE;
        }
        return SeriesConstants.SERIES_NAME_UNIQUE;
    }

    @Override
    public int updateSeries(ProStyle proStyle) {
        return styleMapper.updateSeries(proStyle);
    }

    @Override
    public ProStyle selectSeriesById(int ppsId) {
        return styleMapper.selectSeriesById(ppsId);
    }

}
