package service.impl;

import java.util.List;

import dao.RoleDao;
import pojo.Role;
import service.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roledao;
	
	
    public RoleDao getRoledao() {
		return roledao;
	}


	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}


	/**
     * 获取角色表所有的信息实现方法
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRole() {
		List<Role> rolelist = roledao.findAll();
		return rolelist;
	}


	@Override
	public Role getById(int id) {
		Role role = roledao.findById(id);
		return role;
	}

}
