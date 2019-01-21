package com.zking.logistics.sell.service.imp;

import com.zking.logistics.sell.mapper.MarketMapper;
import com.zking.logistics.sell.model.Market;
import com.zking.logistics.sell.service.IMarketService;
import com.zking.logistics.sell.vo.MarketVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MarketServiceImpl implements IMarketService {

    @Autowired
    private MarketMapper marketMapper;

    @Override
    public int insertSelective(Market record) {
        return marketMapper.insertSelective(record);
    }

    @Override
    public Market selectByPrimaryKey(Integer maid) {
        return marketMapper.selectByPrimaryKey(maid);
    }

    @Override
    public int updateByPrimaryKeySelective(Market record) {
        return marketMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryMarketPager(MarketVo marketVo, PageBean pageBean) {
        return marketMapper.queryMarketPager(marketVo);
    }

    @Transactional
    @Override
    public List<Map<String, Object>> queryMarketMap(MarketVo marketVo) {
        return marketMapper.queryMarketMap(marketVo);
    }
}
