package com.zking.logistics.personnel.service;

import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.vo.DepVo;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门Service
 */
public interface IDepService {
    /**
     * 删除
     * @param uuid
     * @return
     */
    int deleteDep(Integer uuid);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertDep(Dep record);

    /**
     * 查询单个
     * @param uuid
     * @return
     */
    Dep querySingleDep(Integer uuid);

    /**
     * 修改单个
     * @param record
     * @return
     */
    int updateDep(Dep record);

    /**
     * 查询分页
     * @param dep
     * @return
     */
    List<DepVo> queryDepPager(Dep dep, PageBean pageBean);

    /**
     * 查询所有部门
     * @return
     */
    List<Dep> queryDep();

    /**
     * 判断部门名称是否有重复的
     * @param username
     * @return
     */
    boolean isRepetitionDepName(String username);
}