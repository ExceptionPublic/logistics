package com.zking.logistics.sell.mapper;

import com.zking.logistics.sell.model.MarketDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDetailMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MarketDetail record);

    int insertSelective(MarketDetail record);

    MarketDetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MarketDetail record);

    int updateByPrimaryKey(MarketDetail record);
}