package com.zking.logistics.warehouse.mapper;

import com.zking.logistics.warehouse.model.Storedetail;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @param uuid
     * @return
     */
    Storedetail querySingleStoredetail(Integer uuid);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateStoredetail(Storedetail record);

    /**
     * 分页查询
     * @param storedetail
     * @return
     */
    List<Storedetail> queryStoredetailPager(Storedetail storedetail);

}