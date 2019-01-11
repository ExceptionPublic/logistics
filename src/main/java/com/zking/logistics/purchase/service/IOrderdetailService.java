package com.zking.logistics.purchase.service;

import com.zking.logistics.purchase.model.Orderdetail;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采购订单详情
 */
public interface IOrderdetailService {
    /**
     * 查询单个
     * @param uuid
     * @return
     */
    Orderdetail querySingleOrderdetail(Integer uuid);

    /**
     * 分页查询
     * @param orderdetail
     * @return
     */
    List<Orderdetail> queryOrderdetailsPager(Orderdetail orderdetail, PageBean pageBean);

    /**
     * 删除
     * @param uuid
     * @return
     */
    int deleteOrderdetail(Integer uuid);

    /**
     *新增
     * @param record
     * @return
     */
    int insertOrderdetail(Orderdetail record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateOrderdetail(Orderdetail record);

}