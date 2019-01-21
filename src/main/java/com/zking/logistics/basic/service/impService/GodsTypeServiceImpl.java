package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.mapper.GodsTypeMapper;
import com.zking.logistics.basic.model.GodsType;
import com.zking.logistics.basic.service.IGodsTypeService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GodsTypeServiceImpl implements IGodsTypeService {

    @Autowired
    private GodsTypeMapper godsTypeMapper;

    @Transactional
    @Override
    public int updateByPrimaryKey(GodsType record) {
        return godsTypeMapper.updateByPrimaryKey(record);
    }


    @Transactional
    @Override
    public int deleteGoodsTye(GodsType record) {
        return godsTypeMapper.deleteGoodsTye(record);
    }


    @Transactional
    @Override
    public int insert(GodsType record) {
        return godsTypeMapper.insert(record);
    }

    @Override
    public GodsType selectByname(String name) {
        return godsTypeMapper.selectByname(name);
    }

    @Override
    public boolean isGtype(String name) {
        return null!=godsTypeMapper.selectByname(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GodsType> queryLstGoodTypePager(GodsType godsType, PageBean pageBean) {
        return godsTypeMapper.queryLstGoodTypePager(godsType);
    }

    @Override
    public List<GodsType> SelectGtype(GodsType godsType) {
        return godsTypeMapper.SelectGtype(godsType);
    }
}
