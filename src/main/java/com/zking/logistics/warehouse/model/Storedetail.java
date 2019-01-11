package com.zking.logistics.warehouse.model;

import lombok.ToString;

/**
 * 仓库库存
 */
@ToString
public class Storedetail {
    private Integer uuid;

    private Integer storeuuid;

    private Integer goodsuuid;

    private Integer num;

    public Storedetail(Integer uuid, Integer storeuuid, Integer goodsuuid, Integer num) {
        this.uuid = uuid;
        this.storeuuid = storeuuid;
        this.goodsuuid = goodsuuid;
        this.num = num;
    }

    public Storedetail() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Integer storeuuid) {
        this.storeuuid = storeuuid;
    }

    public Integer getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Integer goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}