package com.zking.logistics.warehouse.vo;

import com.zking.logistics.warehouse.model.Inventory;
import lombok.ToString;


@ToString
public class InventoryVo extends Inventory {

    private String startcreatetime;//登记时间

    private String endcreatetime;//登记时间

    public String getStartcreatetime() {
        return startcreatetime;
    }

    public void setStartcreatetime(String startcreatetime) {
        this.startcreatetime = startcreatetime;
    }

    public String getEndcreatetime() {
        return endcreatetime;
    }

    public void setEndcreatetime(String endcreatetime) {
        this.endcreatetime = endcreatetime;
    }
}
