package com.zking.logistics.purchase.service.imp;

import com.zking.logistics.purchase.mapper.OrderdetailMapper;
import com.zking.logistics.purchase.model.Orderdetail;
import com.zking.logistics.purchase.service.IOrderdetailService;
import com.zking.logistics.purchase.vo.OrderdetailVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderdetailServiceImpl implements IOrderdetailService {

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    @Transactional(readOnly = true)
    public Orderdetail querySingleOrderdetail(Integer uuid) {
        return orderdetailMapper.querySingleOrderdetail(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderdetailVo> queryOrderdetailsPager(Orderdetail orderdetail, PageBean pageBean) {
        return orderdetailMapper.queryOrderdetailsPager(orderdetail);
    }

    @Override
    public int deleteOrderdetail(Integer uuid) {
        return orderdetailMapper.deleteOrderdetail(uuid);
    }

    @Override
    public int insertOrderdetail(Orderdetail record) {
        return orderdetailMapper.insertOrderdetail(record);
    }

    @Override
    public int updateOrderdetail(Orderdetail record) {
        return orderdetailMapper.updateOrderdetail(record);
    }
}
