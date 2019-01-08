package com.zking.logistics.personnel.controller;

import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.service.IEmpService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/personnel")
public class EmpController {

    @Autowired
    private IEmpService empService;

    @RequestMapping("/toEmpManage")
    public String toEmpManage(){
        return "personnel/empManage";
    }

    @RequestMapping("/queryEmpPage")
    @ResponseBody
    public Map<String,Object> queryEmpPage(HttpServletRequest request, Emp emp){
        Map<String,Object> map=new HashMap<String, Object>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        map.put("rows",empService.queryEmpPage(emp,pageBean));
        map.put("page",pageBean.getTotal());
        return map;
    }



}
