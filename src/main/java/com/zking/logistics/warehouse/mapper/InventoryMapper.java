package com.zking.logistics.warehouse.mapper;

import com.zking.logistics.warehouse.model.Inventory;
import com.zking.logistics.warehouse.vo.InventoryVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InventoryMapper {
    int deleteByPrimaryKey(Integer uuid);

//    添加盘盈盘亏
    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer uuid);

//    审核盘盈盘亏
    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
//  盘盈盘亏查询分页
    List<Map<String,Object>> queryInventoryPager(InventoryVo inventoryVo);
}