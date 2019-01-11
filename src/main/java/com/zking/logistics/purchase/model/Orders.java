package com.zking.logistics.purchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 采购订单
 */
@ToString
public class Orders implements Serializable {
    private Integer uuid;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private Timestamp createtime;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private Timestamp checktime;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private Timestamp starttime;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private Timestamp endtime;

    private String type;

    private Integer creater;

    private Integer checker;

    private Integer starter;

    private Integer ender;

    private Integer supplieruuid;

    private Float totalmoney;

    private String state;

    private Integer waybillsn;

    public Orders(Integer uuid, Timestamp createtime, Timestamp checktime, Timestamp starttime, Timestamp endtime, String type, Integer creater, Integer checker, Integer starter, Integer ender, Integer supplieruuid, Float totalmoney, String state, Integer waybillsn) {
        this.uuid = uuid;
        this.createtime = createtime;
        this.checktime = checktime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.type = type;
        this.creater = creater;
        this.checker = checker;
        this.starter = starter;
        this.ender = ender;
        this.supplieruuid = supplieruuid;
        this.totalmoney = totalmoney;
        this.state = state;
        this.waybillsn = waybillsn;
    }

    public Orders() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Timestamp checktime) {
        this.checktime = checktime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public Integer getStarter() {
        return starter;
    }

    public void setStarter(Integer starter) {
        this.starter = starter;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public Integer getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Integer supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getWaybillsn() {
        return waybillsn;
    }

    public void setWaybillsn(Integer waybillsn) {
        this.waybillsn = waybillsn;
    }
}