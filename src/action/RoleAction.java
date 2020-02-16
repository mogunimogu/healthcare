package action;

import java.util.List;

import pojo.Role;
import service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {
	private RoleService roleservice;
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public String getallrole()
	{
		System.out.println(1);
		List<Role> rolelist = roleservice.getAllRole();
		ActionContext.getContext().getSession().put("rolelist", rolelist);
		System.out.println(rolelist);
		return SUCCESS;
	}

}
