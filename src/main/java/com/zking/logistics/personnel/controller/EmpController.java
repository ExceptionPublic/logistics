package com.zking.logistics.personnel.controller;

import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.service.IEmpService;
import com.zking.logistics.personnel.vo.EmpVo;
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
@RequestMapping("/personnel/emp")
public class EmpController {

    @Autowired
    private IEmpService empService;

    /**
     * 跳转至查询界面
     * @return
     */
    @RequestMapping("/toEmpManage")
    public String toEmpManage(){
        return "personnel/emp/empManage";
    }


    /**
     * 跳转至新增界面
     * @return
     */
    @RequestMapping("/toInsertOrUpdateEmp")
    public String toInsertOrUpdateEmp(){
        return "personnel/emp/insertOrUpdateEmp";
    }
    /**
     * 跳转修改界面
     * @return
     */
    @RequestMapping("/EditEmp")
    public String EditEmp(){
        return "personnel/emp/EditEmp";
    }



    /**
     * 新增员工
     * @param emp
     * @return
     */
    @RequestMapping("/insertEmp")
    @ResponseBody
    public Map<String,Object> insertEmp(Emp emp){
        CommonUtil.createMap();
        try {
            empService.insertEmp(emp);
            System.out.println("添加员工："+emp);
            CommonUtil.put("message","员工"+emp.getName()+"添加成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @RequestMapping("/updateEmp")
    @ResponseBody
    public Map<String,Object> updateEmp(Emp emp){
        CommonUtil.createMap();
        try {
            empService.updateEmp(emp);
            System.out.println("修改员工："+emp);
            CommonUtil.put("message","员工"+emp.getName()+"修改成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }



    /**
     * 删除员工
     * @param empVo
     * @return
     */
    @RequestMapping("/deleteEmp")
    @ResponseBody
    public Map<String,Object> deleteEmp(EmpVo emp){
        CommonUtil.createMap();
        try {
            empService.delByKey(empVo);
            CommonUtil.put("message","员工"+empVo.getName()+"删除成功");
            CommonUtil.put("success",true);
        } catch (Exception e) {
            CommonUtil.put("message","系统错误");
            CommonUtil.put("success",false);
            e.printStackTrace();
        }
        return CommonUtil.getMap();
    }



    /**
     * 判断员工是否有重复用户名
     * @param username
     * @return
     */
    @RequestMapping("/isRepetitionUsername")
    @ResponseBody
    public Map<String,Object> isRepetitionUsername(String username){
        CommonUtil.createMap();
        boolean repetition = empService.isRepetitionUsername(username);
        CommonUtil.put("success",repetition);
        if(repetition)
        CommonUtil.put("message","‘"+username+"’用户账号已被占用");
        return CommonUtil.getMap();
    }

    /**
     * 员工分页查询返回JOSN数据
     * @param request
     * @param emp
     * @return
     */
    @RequestMapping("/queryEmpPager")
    @ResponseBody
    public Map<String,Object> queryEmpPager(HttpServletRequest request, EmpVo emp){
        Map<String,Object> map=new HashMap<String, Object>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        map.put("data",empService.queryEmpPager(emp,pageBean));
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }

    /**
     * 员工分页Map集合查询返回JOSN数据
     * @param request
     * @param emp
     * @return
     */
    @RequestMapping("/queryEmpMapPager")
    @ResponseBody
    public Map<String,Object> queryEmpMapPager(HttpServletRequest request, EmpVo emp){
        Map<String,Object> map=new HashMap<String, Object>();
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map> maps = empService.queryEmpMapPager(emp, pageBean);
        map.put("data",maps);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }


    /**
     * 员工登录
     * @param empVo
     * @return
     */
    @RequestMapping("/EmpLogin")
    @ResponseBody
    public Map<String,Object> EmpLogin(EmpVo empVo){
        Map<String,Object> map=new HashMap<>();
        EmpVo login = empService.EmpLogin(empVo);

        if(null==login){
            map.put("success",true);
            map.put("message","登录成功");

        }else{
            map.put("success",false);
            map.put("message","账号或密码错误");
        }
        return map;
    }



}
