package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.mapper.StoreMapper;
import com.zking.logistics.basic.model.Store;
import com.zking.logistics.basic.service.IStoreService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public int deleteByPrimaryKey(Store store) {
        return storeMapper.deleteByPrimaryKey(store);
    }

    @Override
    public int insert(Store record) {
        return storeMapper.insert(record);
    }

    @Override
    public Store selectByName(String name) {
        return storeMapper.selectByName(name);
    }

    @Override
    public boolean isStoreName(String name) {
        return null!=storeMapper.selectByName(name);
    }

    @Override
    public int updateByPrimaryKeySelective(Store record) {
        return storeMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryStorePager(Store store, PageBean pageBean) {
        return storeMapper.queryStorePager(store);
    }

    @Override
    public List<Map<String, Object>> empMap() {
        return storeMapper.empMap();
    }
}
