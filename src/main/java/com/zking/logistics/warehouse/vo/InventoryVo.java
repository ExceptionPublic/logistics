package com.zking.logistics.warehouse.vo;

import com.zking.logistics.warehouse.model.Inventory;

import java.util.Date;

public class InventoryVo extends Inventory {

    private Date endcreatetime;//登记时间

    private Date endchecktime;//审查时间

    public Date getEndcreatetime() {
        return endcreatetime;
    }

    public void setEndcreatetime(Date endcreatetime) {
        this.endcreatetime = endcreatetime;
    }

    public Date getEndchecktime() {
        return endchecktime;
    }

    public void setEndchecktime(Date endchecktime) {
        this.endchecktime = endchecktime;
    }
}
