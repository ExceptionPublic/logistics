package com.zking.logistics.roles.controller;

import com.zking.logistics.roles.model.Role;
import com.zking.logistics.roles.service.IRoleService;
import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色
 */
@Controller
@RequestMapping("/roles/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    //查询页面
    @RequestMapping("/toRolelist")
    public String toRolelist(){
        return "/roles/role/RoleList";
    }

    //添加修改页面
    @RequestMapping("/toRoleEdit")
    public String toRoleEdit(){
        return "/roles/role/RoleEdit";
    }

    //查询所有角色
    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList(){
        return roleService.RoleList();
    }

    //判断角色是否重复
    @ResponseBody
    @RequestMapping("/isRolename")
    public Map isRolename(String name){
        CommonUtil.createMap();
        boolean rolename = roleService.isRolename(name);
        CommonUtil.put("success",rolename);
        if(rolename)
            CommonUtil.put("message","‘"+name+"’角色已存在");
        return CommonUtil.getMap();
    }

    //角色查询及分页
    @RequestMapping("/queryRolePager")
    @ResponseBody
    public Map queryRolePager(Role role, HttpServletRequest request){
        PageBean pageBean =new PageBean();
        pageBean.setRequest(request);
        Map map=new HashMap();
        List<Role> roleList = roleService.queryRolePager(role, pageBean);
        map.put("data",roleList);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }

    //添加角色
    @ResponseBody
    @RequestMapping("/innsert")
    public Map insert(Role role){
        CommonUtil.createMap();
        try {
            roleService.insert(role);
            CommonUtil.put("message","添加成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
        }
        return CommonUtil.getMap();
    }

    //角色修改
    @RequestMapping("/updateByRole")
    @ResponseBody
    public Map updateByRole(Role role){
        CommonUtil.createMap();
        try {
            roleService.updateByPrimaryKeySelective(role);
            CommonUtil.put("message","修改成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
        }
        return CommonUtil.getMap();
    }


    //删除角色
    @ResponseBody
    @RequestMapping("/delRole")
    public Map delRole(Role role){
        CommonUtil.createMap();

        try {
            roleService.deleteByRole(role);
            CommonUtil.put("message","删除成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
        }

        return CommonUtil.getMap();
    }





}
