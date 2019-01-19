package com.zking.logistics.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 销售出库
 */
@Controller
@RequestMapping("/sell/sellOrder/salesOutbound")
public class SalesOutboundCon {

    @RequestMapping("/toSalesOutboundList")
    public String toSalesOutboundList() {
        return "/sell/sellOrder/salesOutbound/SalesOutboundList";
    }
}
