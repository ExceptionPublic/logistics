package com.zking.logistics.warehouse.controller;

import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import com.zking.logistics.warehouse.service.IinventoryService;
import com.zking.logistics.warehouse.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/warehouse/inventory")
@Controller
public class InventoryController {

    @Autowired
    private IinventoryService inventoryService;

    //审核页面查询
    @RequestMapping("/toInvenListAudit")
    public String toInvenListAudit(){
        return "warehouse/inventory/audit/InventoryListAudit";
    }
    //登记页面查询
    @RequestMapping("/toInvenListRegister")
    public String toInvenListRegister(){
        return "warehouse/inventory/register/InventoryListRegister";
    }
    //查询页面
    @RequestMapping("/toInvenList")
    public String toInvenList(){
        return "warehouse/inventory/list/InventoryList";
    }
    //审核修改页面
    @RequestMapping("/toInvenEditAudit")
    public String toInvenEditAudit(){
        return "warehouse/inventory/audit/InventoryEditAudit";
    }
    //登记添加页面
    @RequestMapping("/toInvenAddRegister")
    public String toInvenAddRegister(){
        return "warehouse/inventory/register/InventoryAddRegister";
    }

    //盘盈盘亏添加
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String,Object> insert(InventoryVo inventoryVo){
        CommonUtil.createMap();
        try {
            inventoryService.insert(inventoryVo);
            System.out.println(inventoryVo);
            CommonUtil.put("message","添加成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    //盘盈盘亏审核
    @ResponseBody
    @RequestMapping("/updateByPrimaryKeySelective")
    public Map<String,Object> updateByPrimaryKeySelective(InventoryVo inventoryVo){
        CommonUtil.createMap();
        try {
            inventoryService.updateByPrimaryKeySelective(inventoryVo);
            System.out.println(inventoryVo);
            CommonUtil.put("message","修改成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    //盘盈盘亏查询
    @ResponseBody
    @RequestMapping("/queryInventoryPager")
    public Map<String,Object> queryInventoryPager(InventoryVo inventoryVo,
                                                          HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);

        List<Map<String, Object>> maps =
                inventoryService.queryInventoryPager(inventoryVo, pageBean);

        System.out.println("盘盈查询："+maps);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",maps);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;

    }






}
