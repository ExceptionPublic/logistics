package com.zking.logistics.personnel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.util.Date;

@ToString
public class Emp {
    private Integer uuid;

    private String username;

    private String pwd;

    private String name;

    private Integer gender;

    private String email;

    private String tele;

    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer depuuid;

    private Integer roleId;

    public Emp(Integer uuid, String username, String pwd, String name, Integer gender, String email, String tele, String address, Date birthday, Integer depuuid, Integer roleId) {
        this.uuid = uuid;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.tele = tele;
        this.address = address;
        this.birthday = birthday;
        this.depuuid = depuuid;
        this.roleId = roleId;
    }

    public Emp() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDepuuid() {
        return depuuid;
    }

    public void setDepuuid(Integer depuuid) {
        this.depuuid = depuuid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}