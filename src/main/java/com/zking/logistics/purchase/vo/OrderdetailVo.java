package com.zking.logistics.purchase.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zking.logistics.purchase.model.Orderdetail;


public class OrderdetailVo extends Orderdetail {
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "OrderdetailVo：{" +
                "goodsName='" + goodsName + "\'" +",{"+super.toString()+"}}";
    }
}
