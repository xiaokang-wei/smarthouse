package com.ruoyi.project.product.show.service;


import com.ruoyi.project.product.show.domain.ProShow;

import java.util.List;

public interface ShowService {
    List<ProShow> selectSeriesList(ProShow proShow);

    int deleteSeriesByIds(String ids);


    ProShow selectDetailById(int pdId);
}
