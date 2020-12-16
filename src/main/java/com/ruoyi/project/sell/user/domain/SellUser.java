package com.ruoyi.project.sell.user.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Objects;

public class SellUser extends BaseEntity {

    private Long userId;//客户编号
    private String userName;//客户名称
    private String phonenumber;//手机号

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellUser sellUser = (SellUser) o;
        return Objects.equals(userId, sellUser.userId) &&
                Objects.equals(userName, sellUser.userName) &&
                Objects.equals(phonenumber, sellUser.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, phonenumber);
    }

    public SellUser() {
    }

    public SellUser(Long userId, String userName, String phonenumber) {
        this.userId = userId;
        this.userName = userName;
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "SellUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
