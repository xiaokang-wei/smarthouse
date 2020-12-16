package com.ruoyi.project.sell.list.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.sell.list.domain.SellList;
import com.ruoyi.project.sell.list.mapper.SellListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellListServiceImpl implements ISellListService{
    @Autowired
    private SellListMapper sellListMapper;
    //加载订单信息
    @Override
    public List<SellList> selectSellList(SellList sellList) {
        return sellListMapper.selectSellList(sellList);
    }

    //订单唯一性校验
    @Override
    public String checkSellListNameUnique(SellList sellList) {
        Long listId = StringUtils.isNull(sellList.getListId()) ? -1L : sellList.getListId();
        SellList info = sellListMapper.checkSellListNameUnique(sellList.getListName());
        if (StringUtils.isNotNull(info) && info.getListId().longValue() != listId.longValue())
        {
            return UserConstants.SELL_LIST_NAME_NOT_UNIQUE;
        }
        return UserConstants.SELL_LIST_NAME_UNIQUE;
    }

    //新增保存订单
    @Override
    public int insertSellList(SellList sellList) {
        return sellListMapper.insertSellList(sellList);
    }

    //删除订单
    @Override
    public int deleteSellListByIds(String ids) {
        Long[] listIds = Convert.toLongArray(ids);
        return sellListMapper.deleteSellListByIds(listIds);
    }

    //修改订单
    @Override
    public SellList selectSellListById(Long listId) {
        return sellListMapper.selectSellListById(listId);
    }

    //修改保存订单
    @Override
    public int updateSellList(SellList sellList) {
        sellList.setUpdateBy(ShiroUtils.getLoginName());
        return sellListMapper.updateSellList(sellList);
    }

    @Override
    public List<SellList> selectSellListByName(String userName) {
        List<SellList> list = sellListMapper.selectSellListByName(userName);
        return list;
    }
}
