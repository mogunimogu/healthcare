package service;

import java.util.List;

import pojo.Role;

public interface RoleService {
	//��ȡ��ɫ�����е���Ϣ
     public List<Role> getAllRole();
     //�������ƻ�ȡrole��
     public Role getById(int id);

}
