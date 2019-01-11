package com.zking.logistics.basic.service;

import com.zking.logistics.basic.model.Supplier;
import com.zking.logistics.util.PageBean;

import java.util.List;

public interface ISupplierService {
    int deleteSupplier(Supplier supplier);

    int insert(Supplier record);

    int updateByPrimaryKeySelective(Supplier record);

    List<Supplier> querySupplierPager(Supplier supplier, PageBean pageBean);


    Supplier selectByName(String name);
    boolean isRepetitionSuppliertsname(String name);

}