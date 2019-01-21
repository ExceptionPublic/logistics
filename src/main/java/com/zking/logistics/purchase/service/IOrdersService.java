package com.zking.logistics.purchase.service;

import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.vo.OrderdetailVo;
import com.zking.logistics.purchase.vo.OrdersVo;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.io.IOException;
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
    List<OrdersVo> queryOrdersPager(OrdersVo ordersVO, PageBean pageBean);


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
    int insertOrder(OrdersVo  record) throws IOException;

    /**
     * 修改
     * @param record
     * @return
     */
    int updateOrder(Orders record);

    /**
     * 更改订单状态
     * @param orders
     * @return
     */
    int alterOrdersState(Orders orders);


}