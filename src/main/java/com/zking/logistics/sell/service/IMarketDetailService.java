package com.zking.logistics.sell.service;

import com.zking.logistics.sell.model.MarketDetail;
import com.zking.logistics.sell.vo.MarketDetailVo;
import com.zking.logistics.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IMarketDetailService {
    //添加销售详情表
    int insert(MarketDetail record);
    //查询销售详情
    List<Map> queryMarkDetPager(MarketDetailVo marketDetailVo, PageBean pageBean);
    //查询销售订单详情
    List<Map> queryMarkDetMap(MarketDetailVo marketDetailVo);
}
