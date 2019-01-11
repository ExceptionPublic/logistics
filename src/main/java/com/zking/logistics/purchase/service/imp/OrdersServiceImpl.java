package com.zking.logistics.purchase.service.imp;

import com.zking.logistics.purchase.mapper.OrdersMapper;
import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.service.IOrdersService;
import com.zking.logistics.purchase.vo.OrdersVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    @Transactional(readOnly = true)
    public Orders querySingleOrder(Integer uuid) {
        return ordersMapper.querySingleOrder(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orders> queryOrdersPager(OrdersVo ordersVO, PageBean pageBean) {
        return ordersMapper.queryOrdersPager(ordersVO);
    }

    @Override
    public int deleteOrder(Integer uuid) {
        return ordersMapper.deleteOrder(uuid);
    }

    @Override
    public int insertOrder(Orders record) {
        return ordersMapper.insertOrder(record);
    }

    @Override
    public int updateOrder(Orders record) {
        return ordersMapper.updateOrder(record);
    }
}
