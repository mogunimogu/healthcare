package service;

import java.util.List;

import pojo.Role;

public interface RoleService {
	//获取角色表所有的信息
     public List<Role> getAllRole();
     //根据名称获取role表
     public Role getById(int id);

}
