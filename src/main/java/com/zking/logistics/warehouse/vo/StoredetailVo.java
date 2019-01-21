package com.zking.logistics.warehouse.vo;

import com.zking.logistics.basic.model.Goods;
import com.zking.logistics.warehouse.model.Storedetail;

public class StoredetailVo extends Storedetail {
    private Integer supplieruuid;

    private Integer count;

    private Float sumprice;

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getSumprice() {
        return sumprice;
    }

    public void setSumprice() {
        this.sumprice = goods.getOutprice()*count;
    }

    public Integer getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Integer supplieruuid) {
        this.supplieruuid = supplieruuid;
    }
}
