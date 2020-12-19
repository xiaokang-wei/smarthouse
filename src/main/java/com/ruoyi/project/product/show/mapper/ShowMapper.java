package com.ruoyi.project.product.show.mapper;



import com.ruoyi.project.product.show.domain.ProShow;

import java.util.List;

public interface ShowMapper {
    public List<ProShow> selectSeriesList(ProShow proShow);

    int deleteSeriesByIds(String[] pdIds);


    ProShow  selectDetailById(int pdId);
}
