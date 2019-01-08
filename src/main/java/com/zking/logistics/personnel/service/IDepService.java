package com.zking.logistics.personnel.service;

import com.zking.logistics.personnel.model.Dep;
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
    List<Dep> queryDepPage(Dep dep,PageBean pageBean);
}