package com.zking.logistics.warehouse.controller;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.model.Storedetail;
import com.zking.logistics.warehouse.service.IStoredetailService;
import com.zking.logistics.warehouse.service.IStoreoperService;
import com.zking.logistics.warehouse.vo.StoreoperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warehouse/storeoper")
public class StoreoperController {
    @Autowired
    private IStoreoperService storeoperService;

    @RequestMapping("/toStoreoperList")
    public String toStoreoperList(){
        return "warehouse/storeoper/StoreoperList";
    }

    @RequestMapping("/queryStoreoperPager")
    @ResponseBody
    public Map<String,Object> queryStoreoperPager(StoreoperVo storeoperVo,
                                                    HttpServletRequest request) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        List<Map<String, Object>> maps = storeoperService.queryStoreoperPager(storeoperVo, pageBean);

        Map map = new HashMap();
        map.put("data", maps);
        map.put("count", pageBean.getTotal());
        map.put("code", 0);
        return map;
    }
}
