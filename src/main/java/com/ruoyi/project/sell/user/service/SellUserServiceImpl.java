package com.ruoyi.project.sell.user.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.sell.user.domain.SellUser;
import com.ruoyi.project.sell.user.mapper.SellUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellUserServiceImpl implements ISellUserService{
    //声明mapper层属性
    @Autowired
    private SellUserMapper sellUserMapper;

    //查询客户信息集合
    @Override
    public List<SellUser> selectUserList(SellUser sellUser) {
        return sellUserMapper.selectUserList(sellUser);
    }

    //客户手机号唯一性校验
    @Override
    public String checkPhoneUnique(SellUser sellUser) {
        Long userId = StringUtils.isNull(sellUser.getUserId()) ? -1L : sellUser.getUserId();
        SellUser info = sellUserMapper.checkPhoneUnique(sellUser.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.Sell_USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.Sell_USER_PHONE_UNIQUE;
    }

    //新增客户业务方法
    @Override
    public int insertUser(SellUser sellUser) {
        sellUser.setCreateBy(ShiroUtils.getLoginName());
        return sellUserMapper.insertUser(sellUser);
    }

    //根据id获取客户信息
    @Override
    public SellUser selectUserById(Long userId) {
        return sellUserMapper.selectUserById(userId);
    }

    //修改客户信息
    @Override
    public int updateUser(SellUser sellUser) {
        sellUser.setUpdateBy(ShiroUtils.getLoginName());
        return sellUserMapper.updateUser(sellUser);
    }

    //删除
    @Override
    public int deleteUserByIds(String ids) {
        Long[] userIds = Convert.toLongArray(ids);
        return sellUserMapper.deleteUserByIds(userIds);
    }
}
