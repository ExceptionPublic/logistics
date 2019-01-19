package com.zking.logistics.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/report/statistics")
@Controller
public class StatisticsMap {

    //销售统计页面
    @RequestMapping("/toStatistics")
    public String toStatistics(){
        return "report/statistics/Statistics";
    }
}
