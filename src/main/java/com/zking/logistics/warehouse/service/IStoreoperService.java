package com.zking.logistics.warehouse.service;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.model.Storeoper;
import com.zking.logistics.warehouse.vo.StoreoperVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 仓库操作记录
 */
public interface IStoreoperService {
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
     * @param storeoperVo
     * @return
     */
    List<Map<String,Object>> queryStoreoperPager(StoreoperVo storeoperVo, PageBean pageBean);


}