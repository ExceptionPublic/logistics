package com.zking.logistics.sell.service;

import com.zking.logistics.sell.model.Market;
import com.zking.logistics.sell.vo.MarketVo;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IMarketService {
    //录入销售
    int insertSelective(Market record);

    //查询单个
    Market selectByPrimaryKey(Integer maid);

    //修改销售
    int updateByPrimaryKeySelective(Market record);

    //查询销售订单及分页
    List<Map<String,Object>> queryMarketPager(MarketVo marketVo, PageBean pageBean);
}