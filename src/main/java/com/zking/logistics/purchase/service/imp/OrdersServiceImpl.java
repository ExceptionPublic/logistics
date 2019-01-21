package com.zking.logistics.purchase.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.logistics.purchase.mapper.OrderdetailMapper;
import com.zking.logistics.purchase.mapper.OrdersMapper;
import com.zking.logistics.purchase.model.Orderdetail;
import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.service.IOrdersService;
import com.zking.logistics.purchase.vo.OrderdetailVo;
import com.zking.logistics.purchase.vo.OrdersVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    @Transactional(readOnly = true)
    public Orders querySingleOrder(Integer uuid) {
        return ordersMapper.querySingleOrder(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrdersVo> queryOrdersPager(OrdersVo ordersVO, PageBean pageBean) {
        return ordersMapper.queryOrdersPager(ordersVO);
    }

    @Override
    public int deleteOrder(Integer uuid) {
        ordersMapper.deleteOrder(uuid);
        orderdetailMapper.deleteOrderdetail(uuid);
        return 0;
    }

    @Override
    public int insertOrder(OrdersVo record) throws IOException {
        //将json转换为对象
        ObjectMapper mapper = new ObjectMapper();
        List<OrderdetailVo> orderdetailVos = new ArrayList<OrderdetailVo>();
        OrderdetailVo orderdetailVo = null;
        String detail = "";
        for (String orderdetail : record.getOrderdetails()) {
            if (!detail.equals("[]"))
                if (!Pattern.matches("\\{.*}", orderdetail)) {
                    detail += orderdetail + ",";
                } else {
                    orderdetailVo = mapper.readValue(orderdetail, OrderdetailVo.class);
                    orderdetailVos.add(orderdetailVo);
                }
        }
        if (null != detail && !detail.equals("")) {
            orderdetailVo = mapper.readValue(detail.substring(0, detail.length() - 1), OrderdetailVo.class);
            orderdetailVos.add(orderdetailVo);
        }

        //计算订单总金额
        Float sumMoney = 0f;
        for (Orderdetail vo : orderdetailVos) {
            sumMoney += vo.getMoney();
        }
        record.setTotalMoney(sumMoney);
        //新增订单
        ordersMapper.insertOrder(record);
        for (OrderdetailVo orderdetail : orderdetailVos) {
            orderdetail.setOrdersId(record.getOrdersId());
            orderdetailMapper.insertOrderdetail(orderdetail);
        }
        return 0;
    }


    @Override
    public int updateOrder(Orders record) {
        return ordersMapper.updateOrder(record);
    }

    @Override
    public int alterOrdersState(Orders orders) {
        return ordersMapper.alterOrdersState(orders);
    }
}
