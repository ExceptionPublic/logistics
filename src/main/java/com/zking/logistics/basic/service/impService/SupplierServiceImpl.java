package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.mapper.SupplierMapper;
import com.zking.logistics.basic.model.Supplier;
import com.zking.logistics.basic.service.ISupplierService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;


    @Transactional
    @Override
    public int deleteSupplier(Supplier supplier) {
        return supplierMapper.deleteSupplier(supplier);
    }

    @Transactional
    @Override
    public int insert(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Supplier> querySupplierPager(Supplier supplier, PageBean pageBean) {
        return supplierMapper.querySupplierPager(supplier);
    }

    @Transactional
    @Override
    public Supplier selectByName(String name) {
        return supplierMapper.selectByName(name);
    }

    @Override
    public boolean isRepetitionSuppliertsname(String name) {
        return null!=supplierMapper.selectByName(name);
    }

    @Override
    public List<Supplier> SupplierList() {
        return supplierMapper.SupplierList();
    }
}
