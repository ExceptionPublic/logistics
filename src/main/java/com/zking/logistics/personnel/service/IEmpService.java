package com.zking.logistics.personnel.service;

import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.vo.EmpVo;
import com.zking.logistics.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 员工
 */
public interface IEmpService {
    /**
     * 删除对象
     * @param
     * @return
     */
    int deleteEmp(Integer uuid);

    int delByKey(Emp emp);


    /**
     * 新增
     * @param record
     * @return
     */
    int insertEmp(Emp record);

    /**
     * 查询单个
     * @param uuid
     * @return
     */
    Emp querySingleEmp(Integer uuid);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateEmp(Emp record);

    /**
     * 分页查询
     * @param emp
     * @return
     */
    List<EmpVo> queryEmpPager(EmpVo emp, PageBean pageBean);
    List<Map> queryEmpMapPager(EmpVo emp ,PageBean pageBean);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    Emp querySingleEmpUsername(String username);

    /**
     * 判断用户名是否有重复的
     * @param username
     * @return
     */
    boolean isRepetitionUsername(String username);

}