package com.zking.logistics.roles.service;

import com.zking.logistics.roles.model.Role;
import com.zking.logistics.util.PageBean;

import java.util.List;

public interface IRoleService {
    //删除角色
    int deleteByRole(Role role);

    //添加角色
    int insert(Role record);


    //根据名字查询用于判断重复
    Role selectByName(String name);

    boolean isRolename(String name);

    //修改角色
    int updateByPrimaryKeySelective(Role record);



    //角色分页查询
    List<Role> queryRolePager(Role role, PageBean pageBean);
    //查询所有角色下拉
    List<Role> RoleList();

}