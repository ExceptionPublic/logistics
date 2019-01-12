package com.zking.logistics.basic.service;

import com.zking.logistics.basic.model.Goods;
import com.zking.logistics.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IGoodsService {
    //删除商品
    int deleteByPrimaryKey(Goods goods);
    //  添加商品
    int insert(Goods record);


    //    根据name查询用于判断重复
    Goods selectByPrimaryKey(String name);

    //    根据id查询
    Goods selectByUuid(Integer uuid);

    //    商品修改
    int updateByPrimaryKeySelective(Goods record);

    //    商品查询分页
    List<Map<String,Object>> queryGoodsPager(Goods goods, PageBean pageBean);

    boolean isGoodsname(String name);

    List<Map<String, Object>> queryGoodsPager(Goods goods, PageBean pageBean);
    boolean isGoodsname(String name);

}