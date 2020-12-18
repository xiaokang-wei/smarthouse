package com.ruoyi.project.sell.user.mapper;

import com.ruoyi.project.sell.user.domain.SellUser;

import java.util.List;

public interface SellUserMapper {

    public List<SellUser> selectUserList(SellUser sellUser);

    //根据客户手机号获取客户信息
    SellUser checkPhoneUnique(String phonenumber);

    //新增客户
    int insertUser(SellUser sellUser);

    //根据id获取客户信息
    SellUser selectUserById(Long userId);

    //修改客户信息
    int updateUser(SellUser sellUser);

    //删除
    int deleteUserByIds(Long[] userIds);
}
