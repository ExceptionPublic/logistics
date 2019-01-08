package com.zking.logistics.personnel.service.imp;

import com.zking.logistics.personnel.mapper.EmpMapper;
import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.service.IEmpService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int deleteBmp(Integer uuid) {
        return empMapper.deleteBmp(uuid);
    }

    @Override
    public int insertEmp(Emp record) {
        return empMapper.insertEmp(record);
    }

    @Override
    @Transactional(readOnly = true)
    public Emp querySingleEmp(Integer uuid) {
        return empMapper.querySingleEmp(uuid);
    }

    @Override
    public int updateEmp(Emp record) {
        return empMapper.updateEmp(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dep> queryEmpPage(Emp emp, PageBean pageBean) {
        return empMapper.queryEmpPage(emp);
    }
}
