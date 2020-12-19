package com.ruoyi.project.product.view.service;

import com.ruoyi.project.product.manage.domain.ProManage;
import com.ruoyi.project.product.view.domain.ProView;
import com.ruoyi.project.product.view.mapper.ViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewMapper viewMapper;

    @Override
    public List<ProView> selectSeriesList(ProView proView) {
        return viewMapper.selectSeriesList(proView);
    }

    @Override
    public ProView selectDetailById(int pdId) {
        return viewMapper.selectDetailById(pdId);
    }


}
