package com.zking.logistics.basic.controller;

import com.zking.logistics.basic.model.Clients;
import com.zking.logistics.basic.service.IClientsService;
import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.ResponseWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basicJsp/clients")
public class ClientsController {
    @Autowired
    private IClientsService clientsService;

    //客户查询页面
    @RequestMapping("/toqueryClients")
    public String toqueryClients(){
        return "basicJsp/clients/ClientsList";

    }

    //客户查询
    @RequestMapping("/queryLstClients")
    @ResponseBody
    public Map<String,Object> queryLstClients(Clients clients,
                                               HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Clients> clientsList = clientsService.querClientsPager(clients, pageBean);
        Map map=new HashMap();
        map.put("data",clientsList);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;

    }

    //客户新增及修改页面
    @RequestMapping("/toclientsAdd")
    public String toclientsAdd(){
        return "basicJsp/clients/ClientsAdd";
    }


    //客户新增
    @RequestMapping(value = "/clientsAdd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> clientsAdd(Clients clients){
        CommonUtil.createMap();
        try {
            clientsService.insert(clients);
            CommonUtil.put("message","添加"+clients.getName()+"成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();

    }


    //客户修改
    @RequestMapping("/clientsUpdate")
    @ResponseBody
    public Map<String, Object> clientsUpdate(Clients clients){
        CommonUtil.createMap();
        try {
            clientsService.updateByPrimaryKeySelective(clients);
            CommonUtil.put("message","修改"+clients.getName()+"成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();
    }

    //客户删除
    @RequestMapping("/clientsDel")
    @ResponseBody
    public Map<String, Object> clientsDel(Clients clients){
        CommonUtil.createMap();
        try {
            clientsService.deleteByPrimaryKey(clients);
            CommonUtil.put("message","删除"+clients.getName()+"成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();
    }


    //是否重复
    @RequestMapping("/isRepetitionClientsname")
    @ResponseBody
    public Map<String,Object> isRepetitionClientsname(String name){
        CommonUtil.createMap();
        Clients clients = clientsService.selectByName(name);
        boolean repetition = clientsService.isRepetitionClientsname(name);
        CommonUtil.put("success",repetition);
        if(repetition)
            CommonUtil.put("message","‘"+name+"’该客户存在");
        return CommonUtil.getMap();
    }




}
