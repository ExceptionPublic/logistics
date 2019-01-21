package com.zking.logistics.warehouse.vo;

import com.zking.logistics.warehouse.model.Storeoper;

import java.util.Date;

public class StoreoperVo extends Storeoper{
    private String endTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
