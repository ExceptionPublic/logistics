package com.zking.logistics.purchase.service;

import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.vo.OrdersVo;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采购订单
 */
public interface IOrdersService {

    /**
     * 查询单个
     * @param uuid
     * @return
     */
    Orders querySingleOrder(Integer uuid);

    /**
     * 分页查询
     * @param ordersVO
     * @return
     */
    List<Orders> queryOrdersPager(OrdersVo ordersVO, PageBean pageBean);


    /**
     * 删除
     * @param uuid
     * @return
     */
    int deleteOrder(Integer uuid);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertOrder(Orders record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateOrder(Orders record);

}