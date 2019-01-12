package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Goods;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {
    //删除商品
    int deleteByPrimaryKey(Goods goods);
//  添加商品
    int insert(Goods record);

    int insertSelective(Goods record);

//    根据name查询用于判断重复
    Goods selectByPrimaryKey(String name);

//    根据id查询
    Goods selectByUuid(Integer uuid);

//    商品修改
    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

//    商品查询分页
    List<Map<String,Object>> queryGoodsPager(Goods goods);

    List<Goods> queryGoods(Goods goods);
}