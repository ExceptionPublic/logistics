package com.zking.logistics.basic.controller;

import com.zking.logistics.basic.model.Goods;
import com.zking.logistics.basic.service.IGoodsService;
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
@RequestMapping("/basicJsp/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;


    //商品查询
    @RequestMapping("/toqueryGoods")
    public String toqueryGoods(){
        return "basicJsp/goods/GoodsList";

    }

//    查询所有商品页面
    @RequestMapping("/queryGoods")
    @ResponseBody
    public List<Goods> queryGoods(){
        return goodsService.queryGoods();
    }


    //查询所有商品
    @RequestMapping("/queryGoodsPager")
    @ResponseBody
    public Map<String,Object> queryGoodsPager(Goods goods,
                                              HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map<String,Object>> mapList = goodsService.queryGoodsPager(goods, pageBean);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",mapList);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;

    }

//    @RequestMapping("/togoodsAdd")
//    public String togoodsAdd(){
//        return "basicJsp/goods/GoodsAdd";
//    }

    //商品新增
    @RequestMapping(value = "/goodsAdd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> goodsAdd(Goods goods){
        CommonUtil.createMap();
        try {
            goodsService.insert(goods);
            CommonUtil.put("message","添加成功");
            System.out.println(goods);
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();

    }


    //商品修改
    @RequestMapping("/togoodsEdit")
    public String togoodsEdit(){
        return "basicJsp/goods/GoodsEdit";
    }


    @RequestMapping("/goodsUpdate")
    @ResponseBody
    public Map<String, Object> goodsUpdate(Goods goods){
        CommonUtil.createMap();
        System.out.println("商品"+goods);
        try {
            goodsService.updateByPrimaryKeySelective(goods);

            CommonUtil.put("message","修改成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            System.out.println("商品2"+goods);
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();
    }

    //商品删除
    @RequestMapping("/goodsDel")
    @ResponseBody
    public Map<String, Object> goodsDel(Goods goods){
        CommonUtil.createMap();
        try {
            goodsService.deleteByPrimaryKey(goods);
            System.out.println(goods);
            CommonUtil.put("message","删除"+goods.getName()+"成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }

        return CommonUtil.getMap();
    }


    //是否重复
    @RequestMapping("/goodsService")
    @ResponseBody
    public Map<String,Object> goodsService(String name){
        CommonUtil.createMap();
        boolean goodsname = goodsService.isGoodsname(name);
//        System.out.println("商品name:"+goodsname);
        CommonUtil.put("success",goodsname);
        if(goodsname){
            CommonUtil.put("message","‘"+name+"’该商品存在");
        }
        return CommonUtil.getMap();
    }


    //根据商品id查询
    @RequestMapping("/selectByUuid")
    @ResponseBody
    public Map<String,Object> selectByUuid(Integer uuid){
        Map<String,Object> map =new HashMap<String,Object>();
        Goods goods = goodsService.selectByUuid(uuid);
        map.put("goods",goods);
        return map;
    }







}
