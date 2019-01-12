package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMapper {
    int deleteByPrimaryKey(Store store);

    //添加
    int insert(Store record);

    int insertSelective(Store record);

    //用用判断重复
    Store selectByName(String name);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Map<String,Object>> queryStorePager(Store store);
}