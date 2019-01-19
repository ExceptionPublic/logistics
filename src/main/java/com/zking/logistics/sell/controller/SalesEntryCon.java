package com.zking.logistics.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 销售录入
 */
@Controller
@RequestMapping("/sell/sellOrder/salesEntry/")
public class SalesEntryCon {

    @RequestMapping("/toSellOrderEntryList")
    public String toSellOrderEntryList() {
        return "/sell/sellOrder/salesEntry/SellOrderEntryList";
    }

}
