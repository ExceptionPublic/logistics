package com.zking.logistics.warehouse.service.imp;

import com.zking.logistics.warehouse.mapper.StoredetailMapper;
import com.zking.logistics.warehouse.model.Storedetail;
import com.zking.logistics.warehouse.service.IStoredetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoredetailServiceImpl implements IStoredetailService {

    @Autowired
    private StoredetailMapper storedetailMapper;

    @Override
    public int deleteStoredetail(Integer uuid) {
        return storedetailMapper.deleteStoredetail(uuid);
    }

    @Override
    public int insertStoredetail(Storedetail record) {
        return storedetailMapper.insertStoredetail(record);
    }

    @Override
    @Transactional(readOnly = true)
    public Storedetail querySingleStoredetail(Integer uuid) {
        return storedetailMapper.querySingleStoredetail(uuid);
    }

    @Override
    public int updateStoredetail(Storedetail record) {
        return storedetailMapper.updateStoredetail(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Storedetail> queryStoredetailPager(Storedetail storedetail) {
        return storedetailMapper.queryStoredetailPager(storedetail);
    }

}
