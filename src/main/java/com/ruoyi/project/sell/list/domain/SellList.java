package com.ruoyi.project.sell.list.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Objects;

public class SellList extends BaseEntity {

    private Long listId;//订单编号
    private String listName;//订单名称
    private String listClient;//客户
    private Long listAmount;//订单总额
    private String seller;//销售人员

    public SellList() {
    }

    public SellList(Long listId, String listName, String listClient, Long listAmount, String seller) {
        this.listId = listId;
        this.listName = listName;
        this.listClient = listClient;
        this.listAmount = listAmount;
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellList sellList = (SellList) o;
        return Objects.equals(listId, sellList.listId) &&
                Objects.equals(listName, sellList.listName) &&
                Objects.equals(listClient, sellList.listClient) &&
                Objects.equals(listAmount, sellList.listAmount) &&
                Objects.equals(seller, sellList.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId, listName, listClient, listAmount, seller);
    }

    @Override
    public String toString() {
        return "SellList{" +
                "listId=" + listId +
                ", listName='" + listName + '\'' +
                ", listClient='" + listClient + '\'' +
                ", listAmount=" + listAmount +
                ", seller='" + seller + '\'' +
                '}';
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListClient() {
        return listClient;
    }

    public void setListClient(String listClient) {
        this.listClient = listClient;
    }

    public Long getListAmount() {
        return listAmount;
    }

    public void setListAmount(Long listAmount) {
        this.listAmount = listAmount;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
