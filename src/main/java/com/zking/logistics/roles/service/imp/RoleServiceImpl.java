package com.zking.logistics.roles.service.imp;

import com.zking.logistics.roles.mapper.RoleMapper;
import com.zking.logistics.roles.model.Role;
import com.zking.logistics.roles.service.IRoleService;
import com.zking.logistics.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByRole(Role role) {
        return roleMapper.deleteByRole(role);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public Role selectByName(String name) {
        return roleMapper.selectByName(name);
    }

    @Override
    public boolean isRolename(String name) {
        return null!=roleMapper.selectByName(name);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Role> selectByPrimaryKey(Integer depuuid) {
        return roleMapper.selectByPrimaryKey(depuuid);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Map<String,Object>> queryRolePager(Role role, PageBean pageBean) {
        return roleMapper.queryRolePager(role);
    }

    @Override
    public List<Role> RoleList(Role role) {
        return roleMapper.RoleList(role);
    }
}
