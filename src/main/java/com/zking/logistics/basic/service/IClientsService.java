package com.zking.logistics.basic.service;

import com.zking.logistics.basic.model.Clients;
import com.zking.logistics.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IClientsService {
    int deleteByPrimaryKey(Clients clients);

    int insert(Clients record);


    int updateByPrimaryKeySelective(Clients record);

    Clients selectByName(String name);
    boolean isRepetitionClientsname(String name);
    List<Clients> querClientsPager(Clients clients, PageBean pageBean);
}