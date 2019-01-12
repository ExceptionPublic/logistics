package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.mapper.ClientsMapper;
import com.zking.logistics.basic.model.Clients;
import com.zking.logistics.basic.service.IClientsService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ClientsServiceImpl implements IClientsService {

    @Autowired
    private ClientsMapper clientsMapper;

    @Override
    public int deleteByPrimaryKey(Clients clients) {
        return clientsMapper.deleteByPrimaryKey(clients);
    }

    @Override
    public int insert(Clients record) {
        return clientsMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Clients record) {
        return clientsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Clients selectByName(String name) {
        return clientsMapper.selectByName(name);
    }

    @Override
    public boolean isRepetitionClientsname(String name) {
        return null!=clientsMapper.selectByName(name);
    }

    @Override
    public List<Clients> querClientsPager(Clients clients, PageBean pageBean) {
        return clientsMapper.querClientsPager(clients);
    }
}
