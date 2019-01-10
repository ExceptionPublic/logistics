package com.zking.logistics.personnel.service.imp;

import com.zking.logistics.personnel.mapper.EmpMapper;
import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.service.IEmpService;
import com.zking.logistics.personnel.vo.EmpVo;
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
    public List<EmpVo> queryEmpPager(EmpVo emp, PageBean pageBean) {
        return empMapper.queryEmpPager(emp);
    }

    @Override
    public Emp querySingleEmpUsername(String username) {
        return empMapper.querySingleEmpUsername(username);
    }

    @Override
    public boolean isRepetitionUsername(String username) {
        return null!=empMapper.querySingleEmpUsername(username);
    }
}
