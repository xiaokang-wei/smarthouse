package com.ruoyi.project.sell.list.mapper;

import com.ruoyi.project.sell.list.domain.SellList;

import java.util.List;

public interface SellListMapper {
    //查询订单信息集合
    List<SellList> selectSellList(SellList sellList);

    //订单唯一性校验
    SellList checkSellListNameUnique(String listName);

    //新增保存订单
    int insertSellList(SellList sellList);

    //删除订单
    int deleteSellListByIds(Long[] listIds);

    //修改订单
    SellList selectSellListById(Long listId);

    //修改保存订单
    int updateSellList(SellList sellList);

    List<SellList> selectSellListByName(String userName);
}
