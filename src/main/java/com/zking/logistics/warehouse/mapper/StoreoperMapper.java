package com.zking.logistics.warehouse.mapper;

import com.zking.logistics.warehouse.model.Storeoper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 仓库操作记录
 */
@Repository
public interface StoreoperMapper {
    /**
     * 删除
     * @param uuid
     * @return
     */
    int deleteStoreoper(Integer uuid);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertStoreoper(Storeoper record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateStoreoper(Storeoper record);

    /**
     * 查询单个
     * @param uuid
     * @return
     */
    Storeoper querySingleStoreoper(Integer uuid);

    /**
     * 分页查询
     * @param storeoper
     * @return
     */
    List<Storeoper> queryStoreoperPager(Storeoper storeoper);


}