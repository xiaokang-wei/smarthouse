package com.ruoyi.project.sell.user.service;

import com.ruoyi.project.sell.user.domain.SellUser;

import java.util.List;

public interface ISellUserService {

    //查询客户信息集合
    List<SellUser> selectUserList(SellUser sellUser);

    //客户手机号唯一性校验
    String checkPhoneUnique(SellUser sellUser);

    //新增客户业务方法
    int insertUser(SellUser sellUser);

    //根据id获取客户信息
    SellUser selectUserById(Long userId);

    //修改客户信息
    int updateUser(SellUser sellUser);

    //删除
    int deleteUserByIds(String ids);
}
