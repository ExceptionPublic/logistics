package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMapper {
    int deleteByPrimaryKey(Integer uuid);
    int deleteSupplier(Supplier supplier);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Supplier selectByName(String name);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> querySupplierPager(Supplier supplier);
}