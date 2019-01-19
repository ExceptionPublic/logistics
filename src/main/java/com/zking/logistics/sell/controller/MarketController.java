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

    @RequestMapping("/toSellOrderList")
    public String toSellOrderList() {
        return "/sell/sellOrder/SellOrderList";
    }

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

}
