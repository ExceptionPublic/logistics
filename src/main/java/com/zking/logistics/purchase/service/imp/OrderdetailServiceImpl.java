package com.zking.logistics.purchase.service.imp;

import com.zking.logistics.purchase.mapper.OrderdetailMapper;
import com.zking.logistics.purchase.mapper.OrdersMapper;
import com.zking.logistics.purchase.model.Orderdetail;
import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.service.IOrderdetailService;
import com.zking.logistics.purchase.vo.OrderdetailVo;
import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.mapper.StoredetailMapper;
import com.zking.logistics.warehouse.mapper.StoreoperMapper;
import com.zking.logistics.warehouse.model.Storedetail;
import com.zking.logistics.warehouse.model.Storeoper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderdetailServiceImpl implements IOrderdetailService {

    //订单
    @Autowired
    OrdersMapper ordersMapper;
    //订单详情
    @Autowired
    private OrderdetailMapper orderdetailMapper;
    //库存
    @Autowired
    private StoredetailMapper storedetailMapper;
    //仓库变动
    @Autowired
    private StoreoperMapper storeoperMapper;

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
        //判断是否是入库
        if (record.getState().equals("2")) {
            //商品库存
            Storedetail storedetail=new Storedetail();
            storedetail.setGoodsuuid(record.getGoodsId());
            storedetail.setStoreuuid(record.getStoreId());
            Storedetail store = storedetailMapper.querySingleStoredetail(storedetail);
            //判断是否用有次商品库存
            if (null!=store) {
                store.setNum(record.getNum()+(store.getNum()==null? 0 : store.getNum()));
                storedetailMapper.updateStoredetail(store);
            }else{
                store=new Storedetail();
                store.setNum(record.getNum());
                store.setStoreuuid(record.getStoreId());
                store.setGoodsuuid(record.getGoodsId());
                storedetailMapper.insertStoredetail(store);
            }
            //添加仓库变动表
            Storeoper storeoper=new Storeoper();
            storeoper.setEmpuuid(record.getEnder());
            storeoper.setType("入库");
            storeoper.setGoodsuuid(record.getGoodsId());
            storeoper.setStoreuuid(record.getStoreId());
            storeoper.setNum(record.getNum());
            storeoperMapper.insertStoreoper(storeoper);
            //判断是否全部入库
            Orders orders =new Orders();
            orders.setOrdersId(record.getOrdersId());
            System.out.println(record.getOrdersId());
            List<Orderdetail> list = orderdetailMapper.queryOrdersdetail(orders);
            boolean b=true;
            for (Orderdetail orderdetail : list) {
                System.out.println(orderdetail.getState());
                if(!orderdetail.getState().equals("2")){
                    b=false;
                }
            }
            //全部入库
            if(b){
                orders.setState("2");
                ordersMapper.alterOrdersState(orders);
            }
        }
        System.out.println(record);
        return orderdetailMapper.updateOrderdetail(record);
    }
}
