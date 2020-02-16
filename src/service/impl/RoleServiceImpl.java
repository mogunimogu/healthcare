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
     * ��ȡ��ɫ�����е���Ϣʵ�ַ���
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
