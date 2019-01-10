package com.zking.logistics.personnel.mapper;

import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.vo.DepVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门Mapper
 */
@Repository
public interface DepMapper {
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
    List<DepVo> queryDepPager(Dep dep);

    /**
     * 根据部门名称查询部门
     * @param name
     * @return
     */
    Dep queryDepName(String name);

   /**
     * 查询所有部门
     * @return
     */
    List<Dep> queryDep();
}