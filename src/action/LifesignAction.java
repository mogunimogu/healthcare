
package action;

import pojo.Custom;
import pojo.Lifesign;
import pojo.PersonInfo;
import service.LifesignService;
import service.PersonInfoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LifesignAction extends ActionSupport {
	
	private LifesignService lifesifnservice;
	private PersonInfoService personService;
	
	public PersonInfoService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonInfoService personService) {
		this.personService = personService;
	}

	public LifesignService getLifesifnservice() {
		return lifesifnservice;
	}

	public void setLifesifnservice(LifesignService lifesifnservice) {
		this.lifesifnservice = lifesifnservice;
	}
	
	public String getlifesignByName() throws Exception{
		Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
		System.out.println(custom);
		PersonInfo personinfo = personService.getPersonByName(custom);
		Lifesign lifesign = lifesifnservice.getLifesignByPersoninfo(personinfo);
		ActionContext.getContext().getSession().put("lifesign", lifesign);
		System.out.println(lifesign);
		return SUCCESS;
	}

}
