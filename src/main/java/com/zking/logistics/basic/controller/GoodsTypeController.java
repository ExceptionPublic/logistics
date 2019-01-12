package com.zking.logistics.basic.controller;

import com.zking.logistics.basic.model.GodsType;
import com.zking.logistics.basic.service.IGodsTypeService;
import com.zking.logistics.util.CommonUtil;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basicJsp/goodstype")
public class GoodsTypeController {

    @Autowired
    private IGodsTypeService godsTypeService;

    private  Map<String,Object> map=new HashMap<>();

    //应用商品下拉
    @RequestMapping("/SelectGtype")
    @ResponseBody
    public List<GodsType> SelectGtype(){
        return godsTypeService.SelectGtype();
    }

    //类型查询
    @RequestMapping("/toGoodstypeList")
    public String toGoodstypeList(){
        return "basicJsp/goodstype/GoodsTypeList";

    }


    @RequestMapping("/goodsTypeLst")
    @ResponseBody
    public Map<String,Object> queryLstGoodType(GodsType godsType,
                                               HttpServletRequest request){
//        Map<String,Object> map=new HashMap<>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);

        List<GodsType> godsTypes = godsTypeService.queryLstGoodTypePager(godsType, pageBean);
        System.out.println(godsTypes);
        map.put("data",godsTypes);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;

    }

    //类型新增
    @RequestMapping("/togoodstypeAdd")
    public String togoodstypeAdd(){
        return "basicJsp/goodstype/GoodsTypeAdd";
    }


    @RequestMapping(value = "/goodsTypeAdd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> goodsTypeAdd(GodsType godsType){
        System.out.println("新增类型："+godsType);
        int insert = godsTypeService.insert(godsType);
        if(insert>0){
            System.out.println("新增类型："+godsType.getName());
            map.put("success",true);
            map.put("message","新增成功！");

        }
        else{
            map.put("message","新增失败！");
        }

        return map;
    }


    @RequestMapping("/goodsTypeUpdate")
    @ResponseBody
    public Map<String, Object> goodsTypeUpdate(GodsType godsType){
        int updateByPrimaryKey = godsTypeService.updateByPrimaryKey(godsType);
        if(updateByPrimaryKey>0){
            map.put("success", true);
            map.put("message","修改成功！");
        }
        else{
            map.put("message","修改失败！");
        }

        return map;
    }

    //类型删除
    @RequestMapping("/goodsTypeDel")
    @ResponseBody
    public Map<String, Object> goodsTypeDel(GodsType godsType){
        int deleteGoodsTye = godsTypeService.deleteGoodsTye(godsType);
        if(deleteGoodsTye>0) {
            map.put("success", true);
            map.put("message", "删除成功！");
        }
        else{
            map.put("message","删除失败！");
        }
        return map;
    }


    //是否重复
    @RequestMapping("/isGtype")
    @ResponseBody
    public Map<String,Object> isGtype(String name){
        CommonUtil.createMap();
        boolean gtype = godsTypeService.isGtype(name);
        CommonUtil.put("success",gtype);
        if(gtype){
            CommonUtil.put("message","该类型存在");
        }
        return CommonUtil.getMap();
    }





}
