package com.zking.logistics.sell.controller;

import com.zking.logistics.sell.service.IMarketDetailService;
import com.zking.logistics.sell.vo.MarketDetailVo;
import com.zking.logistics.sell.vo.MarketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售出库
 */
@Controller
@RequestMapping("/sell/sellOrder/salesOutbound")
public class SalesOutboundCon {

    @Autowired
    private IMarketDetailService marketDetailService;

    @RequestMapping("/toSalesOutboundList")
    public String toSalesOutboundList() {
        return "/sell/sellOrder/salesOutbound/SalesOutboundList";
    }

    //根据id查询销售明细订单
    @RequestMapping("/queryMarketMap")
    @ResponseBody
    public Map queryMarketMap(MarketDetailVo marketDetailVo){
        Map map=new HashMap();
        List<Map> maps = marketDetailService.queryMarkDetMap(marketDetailVo);
        System.out.println(maps);
        map.put("data",maps);
        map.put("code",0);

        return map;
    }

}
