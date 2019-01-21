package com.zking.logistics.sell.model;

public class MarketDetail {
    private Integer uuid;

    private Integer goodsuuid;

    private Float price;

    private Integer num;

    private Float money;

    private Integer ender;

    private Integer storeuuid;

    private String state;

    private Integer ordersuuid;

    public MarketDetail(Integer uuid, Integer goodsuuid, Float price, Integer num, Float money, Integer ender, Integer storeuuid, String state, Integer ordersuuid) {
        this.uuid = uuid;
        this.goodsuuid = goodsuuid;
        this.price = price;
        this.num = num;
        this.money = money;
        this.ender = ender;
        this.storeuuid = storeuuid;
        this.state = state;
        this.ordersuuid = ordersuuid;
    }

    public MarketDetail() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Integer goodsuuid) {
        this.goodsuuid = goodsuuid;
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

    public Integer getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Integer storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(Integer ordersuuid) {
        this.ordersuuid = ordersuuid;
    }
}