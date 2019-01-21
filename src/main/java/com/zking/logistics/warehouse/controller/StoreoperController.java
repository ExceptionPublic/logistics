package com.zking.logistics.warehouse.controller;

import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.service.IStoreoperService;
import com.zking.logistics.warehouse.vo.StoreoperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库记录查询
 */
@Controller
@RequestMapping("/warehouse/storeoper")
public class StoreoperController {
    @Autowired
    private IStoreoperService storeoperService;

    @RequestMapping("/toStoreoperList")
    public String toStoreoperList(){
        return "warehouse/storeoper/StoreoperList";
    }

    //仓库记录查询
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


    //销售统计柱状图数据
    @RequestMapping("/StatisticsMap")
    @ResponseBody
    public Map<String,Object> StatisticsMap(StoreoperVo storeoperVo){
        List<Map<String,Object>> maps = storeoperService.StatisticsMap(storeoperVo);
        System.out.println("柱状图数据:"+maps);
        //放置柱状图数据
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = null;
        for (Map<String,Object> map1 : maps) {
            map = new HashMap<String,Object>();
            map.put("name", map1.get("gname").toString());
            map.put("y", Integer.parseInt(map1.get("count").toString()));
            list.add(map);
        }
        //放置条目对应使用次
        Map<String,Object> writMap = new HashMap<>();
        writMap.put("series", list);
//        System.out.println("柱状图数据12:"+writMap);

        return writMap;
    }

    //销售统计
    @RequestMapping("/StatisticsListMap")
    @ResponseBody
    public Map<String,Object> StatisticsListMap(StoreoperVo storeoperVo){
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> maps = storeoperService.StatisticsMap(storeoperVo);
//        System.out.println(maps);
//        System.out.println(storeoperVo.getEndTime());
        map.put("data",maps);
        map.put("code",0);
        return map;
    }

    //销售趋势
    @RequestMapping("/TendencyListMap")
    @ResponseBody
    public Map<String,Object> TendencyListMap(StoreoperVo storeoperVo){
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> maps = storeoperService.TendencyMap(storeoperVo);
        System.out.println(maps);
        System.out.println(storeoperVo.getEndTime());
        map.put("data",maps);
        map.put("code",0);
        return map;
    }

    //销售趋势线图
    @RequestMapping("/TendencyMap")
    @ResponseBody
    public Map<String,Object> TendencyMap(StoreoperVo storeoperVo){
        Map<String,Object> writMap = new HashMap<>();
        List<Map<String,Object>> maps =
                storeoperService.TendencyMap(storeoperVo);
        writMap.put("series", maps);
        System.out.println("柱状图数据12:"+writMap);
        return writMap;
    }

}
