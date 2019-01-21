package com.zking.logistics.sell.mapper;

import com.zking.logistics.sell.model.MarketDetail;
import com.zking.logistics.sell.vo.MarketDetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MarketDetailMapper {

    int deleteByPrimaryKey(Integer uuid);

    //添加销售详情表
    int insert(MarketDetail record);

    int insertSelective(MarketDetail record);

    MarketDetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MarketDetail record);

    int updateByPrimaryKey(MarketDetail record);

    //查询销售详情
    List<Map> queryMarkDetPager(MarketDetailVo marketDetailVo);

    //查询根据id销售订单详情
    List<Map> queryMarkDetMap(MarketDetailVo marketDetailVo);


}