package com.zking.logistics.warehouse.service.imp;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.mapper.StoreoperMapper;
import com.zking.logistics.warehouse.model.Storeoper;
import com.zking.logistics.warehouse.service.IStoreoperService;
import com.zking.logistics.warehouse.vo.StoreoperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StoreoperServiceImpl implements IStoreoperService {

    @Autowired
    private StoreoperMapper storeoperMapper;

    @Override
    public int deleteStoreoper(Integer uuid) {
        return storeoperMapper.deleteStoreoper(uuid);
    }

    @Override
    public int insertStoreoper(Storeoper record) {
        return storeoperMapper.insertStoreoper(record);
    }

    @Override
    public int updateStoreoper(Storeoper record) {
        return storeoperMapper.updateStoreoper(record);
    }

    @Override
    @Transactional(readOnly = true)
    public Storeoper querySingleStoreoper(Integer uuid) {
        return storeoperMapper.querySingleStoreoper(uuid);
    }

    @Override
    public List<Map<String, Object>> queryStoreoperPager(StoreoperVo storeoperVo, PageBean pageBean) {
        return storeoperMapper.queryStoreoperPager(storeoperVo);
    }

}
