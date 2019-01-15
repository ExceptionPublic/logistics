package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMapper {
//     删除仓库
    int deleteByPrimaryKey(Store store);

    //添加
    int insert(Store record);

    int insertSelective(Store record);

    //用用判断重复
    Store selectByName(String name);

//    修改仓库
    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

//    查询仓库
    List<Map<String,Object>> queryStorePager(Store store);

//    库管员下拉
    List<Map<String,Object>> empMap();

    //仓库查询所有用于下拉
    List<Store> StoreList();
}