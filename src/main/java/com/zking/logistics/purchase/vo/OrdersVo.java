package com.zking.logistics.purchase.vo;

import com.zking.logistics.purchase.model.Orders;
import lombok.ToString;

@ToString
public class OrdersVo extends Orders {
    private String[] orderdetails;
    private String createName;
    private String supplierName;
    private String checkerName;

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String[] getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(String[] orderdetails) {
        this.orderdetails = orderdetails;
    }
}
