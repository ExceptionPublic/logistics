package com.zking.logistics.purchase.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zking.logistics.purchase.model.Orderdetail;
import lombok.ToString;


@ToString
public class OrderdetailVo extends Orderdetail {
    private String goodsName;
    private String purchaseName;
    private String storeName;
    private String enderName;

    public String getEnderName() {
        return enderName;
    }

    public void setEnderName(String enderName) {
        this.enderName = enderName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

}
