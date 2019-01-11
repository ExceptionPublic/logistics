package com.zking.logistics.basic.service;

import com.zking.logistics.basic.model.Store;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IStoreService {
    int deleteByPrimaryKey(Store store);

    //添加
    int insert(Store record);


    //用用判断重复
    Store selectByName(String name);
    boolean isStoreName(String name);

    int updateByPrimaryKeySelective(Store record);


    List<Map<String,Object>> queryStorePager(Store store, PageBean pageBean);
}