package com.zking.logistics.personnel.controller;

import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.service.IDepService;
import com.zking.logistics.personnel.vo.DepVo;
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

@Controller
@RequestMapping("/personnel/dep")
public class DepController {

    @Autowired
    private IDepService depService;

    /**
     * 跳转至部门管理
     * @return
     */
    @RequestMapping("/toDepManage")
    public String toDepManage(){
        return "personnel/dep/depManage";
    }

    /**
     * 跳转至新增或者修改界面
     * @return
     */
    @RequestMapping("/toInsertOrUpdateDep")
    public String toInsertOrUpdateEmp(){
        return "personnel/dep/insertOrUpdateDep";
    }

    /**
     * 删除部门
     * @param dep
     * @return
     */
    @RequestMapping("/deleteDep")
    @ResponseBody
    public Map<String,Object> deleteDep(Dep dep){
        CommonUtil.createMap();
        try {
            depService.deleteDep(dep.getUuid());
            CommonUtil.put("message","部门："+dep.getName()+"删除成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 修改部门
     * @param dep
     * @return
     */
    @RequestMapping("/updateDep")
    @ResponseBody
    public Map<String,Object> updateDep(Dep dep){
        CommonUtil.createMap();
        try {
            depService.updateDep(dep);
            CommonUtil.put("message","部门："+dep.getName()+"修改成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 新增部门
     * @param dep
     * @return
     */
    @RequestMapping("/insertDep")
    @ResponseBody
    public Map<String,Object> insertDep(Dep dep){
        CommonUtil.createMap();
        try {
            depService.insertDep(dep);
            CommonUtil.put("message","部门："+dep.getName()+"添加成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 判断部门是否有重复用户名
     * @param name
     * @return
     */
    @RequestMapping("/isRepetitionDepName")
    @ResponseBody
    public Map<String,Object> isRepetitionDepName(String name){
        CommonUtil.createMap();
        boolean repetition = depService.isRepetitionDepName(name);
        CommonUtil.put("success",repetition);
        if(repetition)
            CommonUtil.put("message","‘"+name+"’部门已存在");
        return CommonUtil.getMap();
    }



    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/queryDep")
    @ResponseBody
    public List<Dep> queryDep(){
        return depService.queryDep();
    }

    /**
     * 部门分页查询返回JOSN数据
     * @param request
     * @param dep
     * @return
     */
    @RequestMapping("/queryDepPager")
    @ResponseBody
    public Map<String,Object> queryDepPager(HttpServletRequest request, Dep dep){
        Map<String,Object> map=new HashMap<String, Object>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<DepVo> depVos = depService.queryDepPager(dep, pageBean);
        System.out.println("page:"+pageBean.getPage());
        System.out.println("total:"+pageBean.getTotal());
        map.put("data",depService.queryDepPager(dep,pageBean));
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }

}
