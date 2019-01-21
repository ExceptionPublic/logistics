package com.zking.logistics.purchase.mapper;

import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.vo.OrdersVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采购订单
 */
@Repository
public interface OrdersMapper {

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
    List<OrdersVo> queryOrdersPager(OrdersVo ordersVO);


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
    int insertOrder(OrdersVo record);

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