package com.zking.logistics.basic.controller;

import com.zking.logistics.basic.model.Supplier;
import com.zking.logistics.basic.service.ISupplierService;
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

@Controller
@RequestMapping("/basicJsp/supplier")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    private Map<String, Object> map = new HashMap<>();


    //查询所有供应商
    @ResponseBody
    @RequestMapping("/SupplierList")
    public List<Supplier> SupplierList(){
       return supplierService.SupplierList();
    }

    //供应商查询
    @RequestMapping("/toqueryLstSupplier")
    public String toqueryLstSupplier() {
        return "basicJsp/supplier/SupplierList";

    }


    @RequestMapping("/queryLstSupplier")
    @ResponseBody
    public Map<String, Object> queryLstSupplier(Supplier supplier,
                                                HttpServletRequest request) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        List<Supplier> suppliers = supplierService.querySupplierPager(supplier, pageBean);
        System.out.println(suppliers);
        map.put("data", suppliers);
        map.put("count", pageBean.getTotal());
        map.put("code", 0);
        return map;

    }

    //供应商新增
    @RequestMapping("/tosupplierAdd")
    public String tosupplierAdd() {
        return "basicJsp/supplier/SupplierAdd";
    }


    @RequestMapping(value = "/supplierAdd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> supplierAdd(Supplier supplier) {
        int insert = supplierService.insert(supplier);
        if (insert > 0) {
            map.put("success", true);
            map.put("message", "新增成功！");
        } else {
            map.put("message", "新增失败！");
        }

        return map;
    }


    //供应商修改
    @RequestMapping("/supplierUpdate")
    @ResponseBody
    public Map<String, Object> supplierUpdate(Supplier supplier) {
        int updateByPrimaryKey = supplierService.updateByPrimaryKeySelective(supplier);
        if (updateByPrimaryKey > 0) {
            map.put("success", true);
            map.put("message", "修改成功！");
        } else {
            map.put("message", "修改失败！");
        }

        return map;
    }

    //供应商删除
    @RequestMapping("/SupplierDel")
    @ResponseBody
    public Map<String, Object> SupplierDel(Supplier supplier) {
        int deleteSupplier = supplierService.deleteSupplier(supplier);
        if (deleteSupplier > 0) {
            map.put("success", true);
            map.put("message", "删除成功！");
        } else {
            map.put("message", "删除失败！");
        }
        return map;
    }

    //是否重复
    @RequestMapping("/isRepetitionSuppliertsname")
    @ResponseBody
    public Map<String, Object> isRepetitionSuppliertsname(String name) {
        CommonUtil.createMap();
        boolean suppliertsname = supplierService.isRepetitionSuppliertsname(name);
        CommonUtil.put("success", suppliertsname);
        if (suppliertsname) {
            CommonUtil.put("message", "该供应商存在");
        }
        return CommonUtil.getMap();
    }


}
