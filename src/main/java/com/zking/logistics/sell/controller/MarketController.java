package com.zking.logistics.sell.controller;

import com.zking.logistics.sell.service.IMarketService;
import com.zking.logistics.sell.vo.MarketVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售查询
 */
@Controller
@RequestMapping("/sell/sellOrder")
public class MarketController {

    @Autowired
    private IMarketService marketService;

    //查询销售页面
    @RequestMapping("/toSellOrderList")
    public String toSellOrderList() {
        return "/sell/sellOrder/SellOrderList";
    }

    //查询销售详情页面
    @RequestMapping("/toSellParticulars")
    public String toSellParticulars() {
        return "/sell/sellOrder/salesOutbound/SellParticulars";
    }

    //查询销售订单
    @RequestMapping("/queryMarketPager")
    @ResponseBody
    public Map<String,Object> queryMarketPager(MarketVo marketVo,
                                               HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);

        List<Map<String, Object>> queryMarketPager =
                marketService.queryMarketPager(marketVo, pageBean);

        map.put("data",queryMarketPager);
        map.put("count",pageBean.getTotal());
        map.put("code",0);

        return map;
    }

    //根据id查询销售订单
    @RequestMapping("/queryMarketMap")
    @ResponseBody
    public List<Map<String,Object>> queryMarketMap(MarketVo marketVo){
        return marketService.queryMarketMap(marketVo);
    }





}
