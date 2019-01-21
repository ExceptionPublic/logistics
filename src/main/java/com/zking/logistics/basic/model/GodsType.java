package com.zking.logistics.basic.model;

import lombok.ToString;

@ToString
public class GodsType {
    private Integer uuid;

    private String name;

    private Integer supplieruuid;

    public GodsType(Integer uuid, String name,Integer supplieruuid) {
        this.uuid = uuid;
        this.name = name;
        this.supplieruuid=supplieruuid;
    }


    public GodsType() {
        super();
    }

    public Integer getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Integer supplieruuid) {
        this.supplieruuid = supplieruuid;
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
}