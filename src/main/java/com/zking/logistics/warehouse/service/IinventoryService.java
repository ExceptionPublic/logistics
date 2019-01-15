package com.zking.logistics.warehouse.service;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.model.Inventory;
import com.zking.logistics.warehouse.vo.InventoryVo;

import java.util.List;
import java.util.Map;

public interface IinventoryService {
    //    添加盘盈盘亏
    int insert(Inventory record);

    //    审核盘盈盘亏
    int updateByPrimaryKeySelective(Inventory record);

    //  盘盈盘亏查询分页
    List<Map<String,Object>> queryInventoryPager(InventoryVo inventoryVo, PageBean pageBean);
}
