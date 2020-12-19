package com.ruoyi.project.product.show.service;

import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.product.show.domain.ProShow;
import com.ruoyi.project.product.show.mapper.ShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowMapper showMapper;

    @Override
    public List<ProShow> selectSeriesList(ProShow proShow) {
        return showMapper.selectSeriesList(proShow);
    }

    @Override
    public int deleteSeriesByIds(String ids) {
        return showMapper.deleteSeriesByIds(Convert.toStrArray(ids));
    }


    @Override
    public ProShow selectDetailById(int pdId) {
        return showMapper.selectDetailById(pdId);
    }

}
