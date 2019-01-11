package com.zking.logistics.purchase.controller;

import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.service.IOrdersService;
import com.zking.logistics.purchase.vo.OrdersVo;
import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private IOrdersService ordersService;

    /**
     * 跳转至采购管理界面
     * @return
     */
    @RequestMapping("/toPurchase")
    public String toPurchase(){
        return "/purchase/purchase";
    }

    /**
     * 跳转至申请采购界面
     * @return
     */
    @RequestMapping("/toInsertPurchase")
    public String toInsertPurchase(){
        return "/purchase/insertPurchase";
    }

    /**
     * 改变订单状态
     * @param orders
     * @return
     */
    public Map<String,Object> alterOrdersState(Orders orders){
        CommonUtil.createMap();
        try {
            ordersService.updateOrder(orders);
            CommonUtil.put("message","通过成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 订单分页查询返回JOSN数据
     * @param request
     * @param ordersVO
     * @return
     */
    @RequestMapping("/queryOrdersPager")
    @ResponseBody
    public Map<String,Object> queryOrdersPager(HttpServletRequest request, OrdersVo ordersVO){
        Map<String,Object> map=new HashMap<String, Object>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        map.put("data",ordersService.queryOrdersPager(ordersVO,pageBean));
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }




}
