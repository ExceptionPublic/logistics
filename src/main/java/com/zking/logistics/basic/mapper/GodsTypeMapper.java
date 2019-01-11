package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.GodsType;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface GodsTypeMapper {
    int deleteByPrimaryKey(Integer uuid);

//    类型删除
    int deleteGoodsTye(GodsType godsType);

//    类型新增
    int insert(GodsType record);

    int insertSelective(GodsType record);

    //根据name查询
    GodsType selectByname(String name);

    //类型修改
    int updateByPrimaryKeySelective(GodsType record);

    int updateByPrimaryKey(GodsType record);

    //类型查询
    List<GodsType> queryLstGoodTypePager(GodsType godsType);

    //应用商品下拉
    List<GodsType> SelectGtype();
}