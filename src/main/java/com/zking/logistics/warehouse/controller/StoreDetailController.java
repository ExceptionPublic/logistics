package com.zking.logistics.warehouse.controller;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.model.Storedetail;
import com.zking.logistics.warehouse.service.IStoredetailService;
import com.zking.logistics.warehouse.service.IStoreoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warehouse/storeDetail")
public class StoreDetailController {

    @Autowired
    private IStoredetailService storedetailService;

    @RequestMapping("/toStoreDeList")
    public String toStoreDeList(){
        return "warehouse/storeDetail/StoreDetailList";
    }

    @RequestMapping("/queryStoredetailPager")
    @ResponseBody
    public Map<String,Object> queryStoredetailPager(Storedetail storedetail,
                                                 HttpServletRequest request) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Map<String, Object>> maps =
                storedetailService.queryStoredetailPager(storedetail, pageBean);
        Map map = new HashMap();
        map.put("data", maps);
        map.put("count", pageBean.getTotal());
        map.put("code", 0);
        return map;
    }

}
