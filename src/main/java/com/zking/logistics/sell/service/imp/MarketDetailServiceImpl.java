package com.zking.logistics.sell.service.imp;

import com.zking.logistics.sell.mapper.MarketDetailMapper;
import com.zking.logistics.sell.model.MarketDetail;
import com.zking.logistics.sell.service.IMarketDetailService;
import com.zking.logistics.sell.vo.MarketDetailVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MarketDetailServiceImpl implements IMarketDetailService {

    @Autowired
    private MarketDetailMapper marketDetailMapper;

    @Override
    public int insert(MarketDetail record) {
        return marketDetailMapper.insert(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Map> queryMarkDetPager(MarketDetailVo marketDetailVo, PageBean pageBean) {
        return marketDetailMapper.queryMarkDetPager(marketDetailVo);
    }

    @Transactional
    @Override
    public List<Map> queryMarkDetMap(MarketDetailVo marketDetailVo) {
        return marketDetailMapper.queryMarkDetMap(marketDetailVo);
    }
}
