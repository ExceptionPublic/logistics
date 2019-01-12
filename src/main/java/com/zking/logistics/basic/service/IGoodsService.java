package com.zking.logistics.basic.service;

import com.zking.logistics.basic.model.Goods;
import com.zking.logistics.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IGoodsService {
    int deleteByPrimaryKey(Goods goods);

    int insert(Goods record);


    Goods selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Goods record);

    boolean isGoodsname(String name);

    List<Map<String, Object>> queryGoodsPager(Goods goods, PageBean pageBean);

}