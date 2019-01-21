package com.zking.logistics.sell.mapper;

import com.zking.logistics.sell.model.Market;
import com.zking.logistics.sell.vo.MarketVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MarketMapper {
    int insert(Market record);

    //录入销售
    int insertSelective(Market record);

    //查询单个
    Market selectByPrimaryKey(Integer maid);

    //修改销售
    int updateByPrimaryKeySelective(Market record);

    int updateByPrimaryKey(Market record);

    //查询销售订单及分页
    List<Map<String,Object>> queryMarketPager(MarketVo marketVo);

    //根据id查询销售订单
    List<Map<String,Object>> queryMarketMap(MarketVo marketVo);
}