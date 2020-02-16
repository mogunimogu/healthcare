package action;

import pojo.Custom;
import pojo.PersonInfo;
import service.PersonInfoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PersonInfoAction extends ActionSupport {
    private PersonInfoService personinfoservice;

	public PersonInfoService getPersoninfoservice() {
		return personinfoservice;
	}

	public void setPersoninfoservice(PersonInfoService personinfoservice) {
		this.personinfoservice = personinfoservice;
	}
    
	
	public String getPersonByName() throws Exception{
		Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
		PersonInfo personinfo = personinfoservice.getPersonByName(custom);
		ActionContext.getContext().getSession().put("personinfo", personinfo);
		return SUCCESS;
	}
}
