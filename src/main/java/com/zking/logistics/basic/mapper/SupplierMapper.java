package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMapper {
    int deleteByPrimaryKey(Integer uuid);
    //删除供应商
    int deleteSupplier(Supplier supplier);

    //添加供应商
    int insert(Supplier record);

    int insertSelective(Supplier record);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Supplier selectByName(String name);

    //修改供应商
    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

//    供应商查询及分页
    List<Supplier> querySupplierPager(Supplier supplier);
//    供应商查询全部
    List<Supplier> SupplierList();
}