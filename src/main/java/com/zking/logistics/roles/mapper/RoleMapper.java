package com.zking.logistics.roles.mapper;

import com.zking.logistics.roles.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    //删除角色
    int deleteByRole(Role role);

    //添加角色
    int insert(Role record);

    int insertSelective(Role record);

    //根据名字查询用于判断重复
    Role selectByName(String name);

    //修改角色
    int updateByPrimaryKeySelective(Role record);


    int updateByPrimaryKey(Role record);

    //角色分页查询
    List<Role> queryRolePager(Role role);
    //查询所有角色下拉
    List<Role> RoleList();

}