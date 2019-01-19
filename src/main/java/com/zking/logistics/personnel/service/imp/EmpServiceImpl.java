package com.zking.logistics.personnel.service.imp;

import com.zking.logistics.personnel.mapper.EmpMapper;
import com.zking.logistics.personnel.model.Emp;
import com.zking.logistics.personnel.service.IEmpService;
import com.zking.logistics.personnel.vo.EmpVo;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpMapper empMapper;

    @Transactional
    @Override
    public int deleteEmp(Integer uuid) {
        return empMapper.deleteEmp(uuid);
    }

    @Override
    public int delByKey(Emp empVo) {
        return empMapper.delByKey(empVo);
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
    @Transactional(readOnly = true)
    public List<Map> queryEmpMapPager(EmpVo emp, PageBean pageBean) {
        return empMapper.queryEmpMapPager(emp);
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
