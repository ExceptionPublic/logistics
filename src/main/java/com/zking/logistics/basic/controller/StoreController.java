package com.zking.logistics.basic.controller;

import com.zking.logistics.basic.model.Store;
import com.zking.logistics.basic.service.IStoreService;
import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/basicJsp/store")
@Controller
public class StoreController {

    @Autowired
    private IStoreService storeService;


    //仓库查询页面
    @RequestMapping("/toqueryStore")
    public String toqueryStore(){
        return "basicJsp/store/StoreList";

    }


    //查询仓库下拉
    @RequestMapping("/StoreList")
    @ResponseBody
    public List<Store> StoreList(){
        return storeService.StoreList();
    }

    //仓库查询
    @RequestMapping("/queryStorePager")
    @ResponseBody
    public Map<String,Object> queryStorePager(Store store,
                                              HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map<String, Object>> queryStorePager = storeService.queryStorePager(store, pageBean);
        Map map=new HashMap();
        map.put("data",queryStorePager);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;

    }

    //新增or修改的路径
    @RequestMapping("/tostoreEdit")
    public String tostoreEdit(){
        return "basicJsp/store/StoreEdit";
    }

    //新增仓库
    @RequestMapping(value = "/storeAdd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> storeAdd(Store store){
        CommonUtil.createMap();
        try {
            int insert = storeService.insert(store);
            CommonUtil.put("message","添加成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();

    }



    //仓库修改
    @RequestMapping("/storeUpdate")
    @ResponseBody
    public Map<String, Object> storeUpdate(Store store){
        CommonUtil.createMap();
        System.out.println("商品"+store);
        try {
            int i = storeService.updateByPrimaryKeySelective(store);

            CommonUtil.put("message","修改成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();
    }

    //商品删除
    @RequestMapping("/storeDel")
    @ResponseBody
    public Map<String, Object> storeDel(Store store){
        CommonUtil.createMap();
        try {
            int i = storeService.deleteByPrimaryKey(store);
            CommonUtil.put("message","删除成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();
    }


    //是否重复
    @RequestMapping("/storeService")
    @ResponseBody
    public Map<String,Object> storeService(String name){
        CommonUtil.createMap();
        boolean storename = storeService.isStoreName(name);
        CommonUtil.put("success",storename);
        if(storename){
            CommonUtil.put("message","该仓库存在");
        }
        return CommonUtil.getMap();
    }


    @RequestMapping("/empMap")
    @ResponseBody
    public List<Map<String,Object>> empMap(){
        return storeService.empMap();
    }

}
