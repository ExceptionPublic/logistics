package com.zking.logistics.purchase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.purchase.model.Orderdetail;
import com.zking.logistics.purchase.model.Orders;
import com.zking.logistics.purchase.service.IOrderdetailService;
import com.zking.logistics.purchase.service.IOrdersService;
import com.zking.logistics.purchase.vo.OrderdetailVo;
import com.zking.logistics.purchase.vo.OrdersVo;
import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import com.zking.logistics.util.StringUtil;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IOrderdetailService orderdetailService;

    /**
     * 跳转至采购管理界面
     *
     * @return
     */
    @RequestMapping("/toPurchase")
    public String toPurchase() {
        return "/purchase/purchase";
    }

    /**
     * 跳转至申请采购界面
     *
     * @return
     */
    @RequestMapping("/toInsertPurchase")
    public String toInsertPurchase() {
        return "purchase/insertPurchase";
    }

    /**
     * 跳转至申请采购界面
     *
     * @return
     */
    @RequestMapping("/toInsertOrderdetail")
    public String toInsertOrderdetail() {
        return "purchase/insertOrderdetail";
    }

    /**
     * 跳转至订单详情界面
     *
     * @return
     */
    @RequestMapping("/toOrderDetail")
    public String toOrderDetail() {
        return "purchase/orderdetail";
    }

    /**
     * 改变订单状态
     *
     * @param orders
     * @return
     */
    @RequestMapping("/alterOrdersState")
    @ResponseBody
    public Map<String, Object> alterOrdersState(Orders orders,HttpSession session) {
        CommonUtil.createMap();

        try {
            Emp emp = (Emp) session.getAttribute("emp");
//            orders.setChecker(emp.getUuid());
            orders.setChecker(5);
            orders.setCheckerDate(new Date());
            ordersService.updateOrder(orders);
            CommonUtil.put("message", "通过成功");
            CommonUtil.put("success", true);
        } catch (Exception e) {
            CommonUtil.put("message", "系统错误");
            CommonUtil.put("success", false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 改变订单详情状态
     *
     * @param orderdetail
     * @return
     */
    @RequestMapping("/alterOrdersDetailState")
    @ResponseBody
    public Map<String, Object> alterOrdersDetailState(Orderdetail orderdetail,HttpSession session) {
        CommonUtil.createMap();
        Emp emp = (Emp) session.getAttribute("emp");
        try {
            String str="";
//            orderdetail.setPurchase(emp.getUuid());
            if(orderdetail.getState().equals("1")){
                orderdetail.setPurchaseDate(new Date());
                orderdetail.setPurchase(5);
                str="采购";
            }else if(orderdetail.getState().equals("2")){
                orderdetail.setEnder(5);
                orderdetail.setEnderDate(new Date());
                str="入库";
            }
            orderdetailService.updateOrderdetail(orderdetail);
            CommonUtil.put("message", str+"成功");
            CommonUtil.put("success", true);
        } catch (Exception e) {
            CommonUtil.put("message", "系统错误");
            CommonUtil.put("success", false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 订单分页查询返回JOSN数据
     *
     * @param request
     * @param ordersVO
     * @return
     */
    @RequestMapping("/queryOrdersPager")
    @ResponseBody
    public Map<String, Object> queryOrdersPager(HttpServletRequest request, OrdersVo ordersVO) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        map.put("data", ordersService.queryOrdersPager(ordersVO, pageBean));
        map.put("count", pageBean.getTotal());
        map.put("code", 0);
        return map;
    }


    /**
     * 订单详情分页查询返回JOSN数据
     *
     * @param request
     * @param ordersVO
     * @return
     */
    @RequestMapping("/queryOrdersDetailPager")
    @ResponseBody
    public Map<String, Object> queryOrdersDetailPager(HttpServletRequest request, Orderdetail ordersVO) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<OrderdetailVo> orderdetailVos = orderdetailService.queryOrderdetailsPager(ordersVO, pageBean);
        map.put("data", orderdetailService.queryOrderdetailsPager(ordersVO, pageBean));
        map.put("count", pageBean.getTotal());
        map.put("code", 0);
        return map;
    }

    /**
     * 新增采购订单
     *
     * @return
     */
    @RequestMapping("/insertOrder")
    @ResponseBody
    public Map<String, Object> insertOrder(@RequestParam String[] orderdetails, Integer supplierId, HttpSession session) throws IOException {
        CommonUtil.createMap();
        OrdersVo ordersVo = new OrdersVo();
        ordersVo.setOrderdetails(orderdetails);
        ordersVo.setSupplierId(supplierId);
        //获取下单员
//        Emp emp = (Emp) session.getAttribute("emp");
//        ordersVo.setCreate(emp.getUuid());
        ordersVo.setCreate(5);
        try {
            ordersService.insertOrder(ordersVo);
            CommonUtil.put("message", "申请成功");
            CommonUtil.put("success", true);
        } catch (Exception e) {
            CommonUtil.put("message", "系统错误");
            CommonUtil.put("success", false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 取消订单
     *
     * @param ordersId
     * @return
     */
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public Map<String, Object> deleteOrder(@RequestParam Integer ordersId) {
        CommonUtil.createMap();
        try {
            ordersService.deleteOrder(ordersId);
            CommonUtil.put("message", "取消成功");
            CommonUtil.put("success", true);
        } catch (Exception e) {
            CommonUtil.put("message", "系统错误");
            CommonUtil.put("success", false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }


}
