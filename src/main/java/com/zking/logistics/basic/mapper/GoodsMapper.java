package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Goods goods);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Map<String,Object>> queryGoodsPager(Goods goods);

    List<Goods> queryGoods(Goods goods);
}