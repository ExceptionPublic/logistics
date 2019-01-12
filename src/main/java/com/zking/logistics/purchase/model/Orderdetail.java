package com.zking.logistics.purchase.model;

import java.util.Date;

public class Orderdetail {
    private Integer detailId;

    private Float price;

    private Integer num;

    private Float money;

    private Integer ender;

    private Date enderDate;

    private Integer purchase;

    private Date purchaseDate;

    private Integer storeId;

    private String state;

    private Integer ordersId;

    public Orderdetail(Integer detailId, Float price, Integer num, Float money, Integer ender, Date enderDate, Integer purchase, Date purchaseDate, Integer storeId, String state, Integer ordersId) {
        this.detailId = detailId;
        this.price = price;
        this.num = num;
        this.money = money;
        this.ender = ender;
        this.enderDate = enderDate;
        this.purchase = purchase;
        this.purchaseDate = purchaseDate;
        this.storeId = storeId;
        this.state = state;
        this.ordersId = ordersId;
    }

    public Orderdetail() {
        super();
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public Date getEnderDate() {
        return enderDate;
    }

    public void setEnderDate(Date enderDate) {
        this.enderDate = enderDate;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }
}