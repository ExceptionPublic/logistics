package com.zking.logistics.basic.service;

import com.zking.logistics.basic.model.GodsType;
import com.zking.logistics.util.PageBean;

import java.util.List;


public interface IGodsTypeService {

    int updateByPrimaryKey(GodsType record);
    int deleteGoodsTye(GodsType record);
    int insert(GodsType record);

    GodsType selectByname(String name);
    boolean isGtype(String name);

    List<GodsType> queryLstGoodTypePager(GodsType godsType, PageBean pageBean);
    //应用商品下拉
    List<GodsType> SelectGtype(GodsType godsType);
}