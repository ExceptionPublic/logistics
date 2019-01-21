package com.zking.logistics.sell.controller;

import com.zking.logistics.sell.service.IMarketDetailService;
import com.zking.logistics.sell.service.IMarketService;
import com.zking.logistics.sell.vo.MarketDetailVo;
import com.zking.logistics.sell.vo.MarketVo;
import com.zking.logistics.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 销售录入
 */
@Controller
@RequestMapping("/sell/sellOrder/salesEntry")
public class SalesEntryCon {

    //销售订单
    @Autowired
    private IMarketService marketService;

    //销售详情
    @Autowired
    private IMarketDetailService marketDetailService;
    //销售录入查询页面
    @RequestMapping("/toSellOrderEntryList")
    public String toSellOrderEntryList() {
        return "/sell/sellOrder/salesEntry/SellOrderEntryList";
    }

    //销售订单添加页面
    @RequestMapping("/toSellOrderEntryAdd")
    public String toSellOrderEntryAdd() {
        return "/sell/sellOrder/salesEntry/SellOrderEntryAdd";
    }

    //销售订单添加商品
    @RequestMapping("/toSellOrderEntryGoods")
    public String toSellOrderEntryGoods(){
        return "/sell/sellOrder/salesEntry/SellOrderEntryGoods";
    }


    @RequestMapping("/insertMarket")
    @ResponseBody
    public Map<String,Object> insertMarket(MarketVo marketVo,
                                MarketDetailVo marketDetailVo){
        CommonUtil.createMap();
        try {
            marketService.insertSelective(marketVo);
            marketDetailVo.setOrdersuuid(marketVo.getMaid());
            System.out.println("销售id:"+marketDetailVo.getOrdersuuid());
            marketDetailService.insert(marketDetailVo);
            CommonUtil.put("success",true);
            CommonUtil.put("message","添加订单成功");
        }catch (Exception e){
            CommonUtil.put("message","系统错误");
            e.printStackTrace();
        }

        return CommonUtil.getMap();

    }






}
