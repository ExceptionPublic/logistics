package com.zking.logistics.sell.model;

import java.util.Date;

public class Market {
    private Integer maid;

    private Date markettime;

    private Date chukutime;

    private Integer salesman;

    private Integer ender;

    private Integer supplieruuid;

    private Float totalmoney;

    private String state;

    public Market(Integer maid, Date markettime, Date chukutime, Integer salesman, Integer ender, Integer supplieruuid, Float totalmoney, String state) {
        this.maid = maid;
        this.markettime = markettime;
        this.chukutime = chukutime;
        this.salesman = salesman;
        this.ender = ender;
        this.supplieruuid = supplieruuid;
        this.totalmoney = totalmoney;
        this.state = state;
    }

    public Market() {
        super();
    }

    public Integer getMaid() {
        return maid;
    }

    public void setMaid(Integer maid) {
        this.maid = maid;
    }

    public Date getMarkettime() {
        return markettime;
    }

    public void setMarkettime(Date markettime) {
        this.markettime = markettime;
    }

    public Date getChukutime() {
        return chukutime;
    }

    public void setChukutime(Date chukutime) {
        this.chukutime = chukutime;
    }

    public Integer getSalesman() {
        return salesman;
    }

    public void setSalesman(Integer salesman) {
        this.salesman = salesman;
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
}