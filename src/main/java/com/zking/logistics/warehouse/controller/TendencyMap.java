package com.zking.logistics.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/tendency")
public class TendencyMap {
    //销售趋势页面
    @RequestMapping("/toTendency")
    public String toTendency(){
        return "report/tendency/Tendency";
    }
}
