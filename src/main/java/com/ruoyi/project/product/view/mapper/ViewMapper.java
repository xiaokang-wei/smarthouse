package com.ruoyi.project.product.view.mapper;


import com.ruoyi.project.product.view.domain.ProView;

import java.util.List;

public interface ViewMapper {
    public List<ProView> selectSeriesList(ProView proView);


    ProView selectDetailById(int pdId);


}
