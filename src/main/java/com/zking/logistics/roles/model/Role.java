package com.zking.logistics.roles.model;

public class Role {
    private Integer uuid;

    private String name;

    public Role(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Role() {
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