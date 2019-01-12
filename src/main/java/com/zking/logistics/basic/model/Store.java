package com.zking.logistics.basic.model;

public class Store {
    private Integer uuid;

    private String name;

    private String address;

    private Integer empuuid;

    public Store(Integer uuid, String name, String address, Integer empuuid) {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Integer empuuid) {
        this.empuuid = empuuid;
    }
}