package com.zking.logistics.sell.vo;

import com.zking.logistics.sell.model.Market;

public class MarketVo extends Market {
    private String startcreatetime;
    private String endcreatetime;

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
