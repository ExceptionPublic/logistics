package com.zking.logistics.warehouse.service.imp;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.mapper.InventoryMapper;
import com.zking.logistics.warehouse.model.Inventory;
import com.zking.logistics.warehouse.service.IinventoryService;
import com.zking.logistics.warehouse.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class InventoryServiceImpl implements IinventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;


    @Override
    public int insert(Inventory record) {
        return inventoryMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Inventory record) {
        return inventoryMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryInventoryPager(InventoryVo inventoryVo, PageBean pageBean) {
        return inventoryMapper.queryInventoryPager(inventoryVo);
    }
}
