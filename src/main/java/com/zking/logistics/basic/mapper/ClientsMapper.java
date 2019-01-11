package com.zking.logistics.basic.mapper;

import com.zking.logistics.basic.model.Clients;

import java.util.List;

public interface ClientsMapper {
    int deleteByPrimaryKey(Clients clients);

    int insert(Clients record);

    int insertSelective(Clients record);

    Clients selectByName(String name);

    int updateByPrimaryKeySelective(Clients record);

    int updateByPrimaryKey(Clients record);

    List<Clients> querClientsPager(Clients clients);
}