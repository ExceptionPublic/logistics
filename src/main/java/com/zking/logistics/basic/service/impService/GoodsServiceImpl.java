package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.mapper.GoodsMapper;
import com.zking.logistics.basic.model.Goods;
import com.zking.logistics.basic.service.IGoodsService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Goods goods) {
        return goodsMapper.deleteByPrimaryKey(goods);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public Goods selectByPrimaryKey(String name) {
        return goodsMapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean isGoodsname(String name) {
        return null!=goodsMapper.selectByPrimaryKey(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryGoodsPager(Goods goods, PageBean pageBean) {
        return goodsMapper.queryGoodsPager(goods);
    }
}
