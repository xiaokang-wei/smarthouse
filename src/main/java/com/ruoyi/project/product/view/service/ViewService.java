package com.ruoyi.project.product.view.service;


import com.ruoyi.project.product.view.domain.ProView;

import java.util.List;

public interface ViewService {
    List<ProView> selectSeriesList(ProView proView);

    ProView selectDetailById(int pdId);

}
