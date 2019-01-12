package com.zking.logistics.basic.model;

public class Goods {
    private Integer uuid;

    private String name;

    private Integer supplieruuid;

    private String unit;

    private Float inprice;

    private Float outprice;

    private Integer goodstypeuuid;

    public Goods(Integer uuid, String name, Integer supplieruuid, String unit, Float inprice, Float outprice, Integer goodstypeuuid) {
        this.uuid = uuid;
        this.name = name;
        this.supplieruuid = supplieruuid;
        this.unit = unit;
        this.inprice = inprice;
        this.outprice = outprice;
        this.goodstypeuuid = goodstypeuuid;
    }

    public Goods() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Integer supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getInprice() {
        return inprice;
    }

    public void setInprice(Float inprice) {
        this.inprice = inprice;
    }

    public Float getOutprice() {
        return outprice;
    }

    public void setOutprice(Float outprice) {
        this.outprice = outprice;
    }

    public Integer getGoodstypeuuid() {
        return goodstypeuuid;
    }

    public void setGoodstypeuuid(Integer goodstypeuuid) {
        this.goodstypeuuid = goodstypeuuid;
    }
}