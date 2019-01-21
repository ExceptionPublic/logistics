package com.zking.logistics.roles.model;

import lombok.ToString;

@ToString
public class Role {
    private Integer uuid;

    private String name;

    private Integer depuuid;

    public Role(Integer uuid, String name, Integer depuuid) {
        this.uuid = uuid;
        this.name = name;
        this.depuuid = depuuid;
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

    public Integer getDepuuid() {
        return depuuid;
    }

    public void setDepuuid(Integer depuuid) {
        this.depuuid = depuuid;
    }
}