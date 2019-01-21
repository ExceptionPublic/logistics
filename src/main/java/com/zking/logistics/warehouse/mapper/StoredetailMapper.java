package com.zking.logistics.warehouse.mapper;

import com.zking.logistics.warehouse.model.Storedetail;
import com.zking.logistics.warehouse.vo.StoredetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 仓库库存
 */
@Repository
public interface StoredetailMapper {
    /**
     * 删除
     * @param uuid
     * @return
     */
    int deleteStoredetail(Integer uuid);

    /**
     * 添加
     * @param record
     * @return
     */
    int insertStoredetail(Storedetail record);

    /**
     * 查询单个
     * @param storedetail
     * @return
     */
    Storedetail querySingleStoredetail(Storedetail storedetail);


    /**
     * 修改
     * @param record
     * @return
     */
    int updateStoredetail(Storedetail record);

    /**
     * 分页查询
     * @param storedetailVo
     * @return
     */
    List<Map<String,Object>> queryStoredetailPager(StoredetailVo storedetailVo);

}