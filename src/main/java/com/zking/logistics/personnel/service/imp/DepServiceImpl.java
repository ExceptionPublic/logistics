package com.zking.logistics.personnel.service.imp;

import com.zking.logistics.personnel.mapper.DepMapper;
import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.service.IDepService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepServiceImpl implements IDepService {

    @Autowired
    private DepMapper depMapper;

    @Override
    public int deleteDep(Integer uuid) {
        return depMapper.deleteDep(uuid);
    }

    @Override
    public int insertDep(Dep record) {
        return depMapper.insertDep(record);
    }

    @Override
    @Transactional(readOnly = true)
    public Dep querySingleDep(Integer uuid) {
        return depMapper.querySingleDep(uuid);
    }

    @Override
    public int updateDep(Dep record) {
        return depMapper.updateDep(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dep> queryDepPage(Dep dep, PageBean pageBean) {
        return depMapper.queryDepPage(dep);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dep> queryDep() {
        return depMapper.queryDep();
    }
}
