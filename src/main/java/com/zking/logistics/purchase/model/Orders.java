package com.zking.logistics.purchase.model;

import java.util.Date;

public class Orders {
    private Integer ordersId;

    private Date createDate;

    private Date checkerDate;

    private Integer create;

    private Integer checker;

    private Integer supplierId;

    private Float totalMoney;

    private String state;

    public Orders(Integer ordersId, Date createDate, Date checkerDate, Integer create, Integer checker, Integer supplierId, Float totalMoney, String state) {
        this.ordersId = ordersId;
        this.createDate = createDate;
        this.checkerDate = checkerDate;
        this.create = create;
        this.checker = checker;
        this.supplierId = supplierId;
        this.totalMoney = totalMoney;
        this.state = state;
    }

    public Orders() {
        super();
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCheckerDate() {
        return checkerDate;
    }

    public void setCheckerDate(Date checkerDate) {
        this.checkerDate = checkerDate;
    }

    public Integer getCreate() {
        return create;
    }

    public void setCreate(Integer create) {
        this.create = create;
    }

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}