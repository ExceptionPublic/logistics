package com.zking.logistics.warehouse.vo;

import com.zking.logistics.warehouse.model.Storeoper;

import java.util.Date;

public class StoreoperVo extends Storeoper{
    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
