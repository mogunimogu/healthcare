package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import pojo.Custom;
import pojo.Role;
import service.CustomService;
import service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomAction extends ActionSupport {
	private CustomService customservice;
	private Custom custom;
	private RoleService roleservice;
	private InputStream inputStream;
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}

	public CustomService getCustomservice() {
		return customservice;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public void setCustomservice(CustomService customservice) {
		this.customservice = customservice;
	}

	public String login() throws Exception {
		Custom cus = customservice.login(custom.getCustomName(), custom.getCustomPwd());
		ActionContext.getContext().getSession().put("cus", cus);
		System.out.println(cus);
		return SUCCESS;
	}
	
	public String delogin() throws Exception{
		ActionContext.getContext().getSession().remove("cus");
		return SUCCESS;
	}
	
	public String register() throws Exception{
		Role r = roleservice.getById(custom.getRole().getRoleId());
		System.out.println(r);
		Custom custom1 = new Custom(r, custom.getCustomName(), custom.getCustomPwd(), custom.getCustomEmail(),custom.getCustomSex());
		customservice.registerCustom(custom1);
		return SUCCESS;
	}
	
	public String isbyname() throws Exception{
		String result = "";
		System.out.println(custom.getCustomName());
		Custom custom1 = customservice.isByName(custom.getCustomName());
		if(custom1!=null)
		{
			if(!custom.getCustomName().equals(""))
			{
				result="用户名已存在";
				System.out.println(result);
			}
			
		}
		inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		return SUCCESS;
	}
}
