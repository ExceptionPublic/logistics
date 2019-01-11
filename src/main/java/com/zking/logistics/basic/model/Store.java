package com.zking.logistics.basic.model;

public class Store {
    private Integer uuid;

    private String name;

    private Integer empuuid;

    public Store(Integer uuid, String name, Integer empuuid) {
        this.uuid = uuid;
        this.name = name;
        this.empuuid = empuuid;
    }

    public Store() {
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

    public Integer getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Integer empuuid) {
        this.empuuid = empuuid;
    }
}