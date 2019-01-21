package com.zking.logistics.personnel.mapper;

import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.vo.EmpVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmpMapper {
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
     * 根据用户名查询
     * @param username
     * @return
     */
    Emp querySingleEmpUsername(String username);


    /**
     * 分页查询
     * @param emp
     * @return
     */
    List<EmpVo> queryEmpPager(EmpVo emp );

    List<Map> queryEmpMapPager(EmpVo emp );

    /**
     * 员工登录
     * @param empVo
     * @return
     */
    EmpVo EmpLogin(EmpVo empVo);


}