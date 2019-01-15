package com.zking.logistics.warehouse.service;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.model.Storedetail;

import java.util.List;
import java.util.Map;

/**
 * 仓库库存
 */
public interface IStoredetailService {
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
    List<Map<String,Object>> queryStoredetailPager(Storedetail storedetail, PageBean pageBean);

}