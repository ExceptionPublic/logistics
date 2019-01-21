package com.zking.logistics.purchase.mapper;

import com.zking.logistics.purchase.model.Orderdetail;
import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.vo.OrderdetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采购订单详情
 */
@Repository
public interface OrderdetailMapper {
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
    List<OrderdetailVo> queryOrderdetailsPager(Orderdetail orderdetail);

    /**
     * 根据订单编号查询
     * @param orders
     * @return
     */
    List<Orderdetail> queryOrdersdetail(Orders orders);

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