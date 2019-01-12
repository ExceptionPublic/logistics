package com.zking.logistics.basic.model;

import lombok.ToString;

@ToString
public class GodsType {
    private Integer uuid;

    private String name;

    public GodsType(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public GodsType() {
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
}