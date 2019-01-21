package com.zking.logistics.personnel.vo;

import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class EmpVo extends Emp {
    private String genders;
    private String depName;
    private String rname;

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<String> getGenders() {
        List<String> list=new ArrayList<String>();
        if(StringUtil.isBlank(genders))
            for (String gender : genders.split(",") ) {
                if(StringUtil.isBlank(gender))
                    list.add(gender);
            }


        return  list;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }
}
