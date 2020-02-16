package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import pojo.Custom;
import pojo.Publish;
import service.PublishService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class PublishAction implements Action {
	private PublishService publishService;
	private Custom custom;
	private Publish publish;
	private List<Publish> plist;

	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Publish getPublish() {
		return publish;
	}

	public void setPublish(Publish publish) {
		this.publish = publish;
	}

	public List<Publish> getPlist() {
		return plist;
	}

	public void setPlist(List<Publish> plist) {
		this.plist = plist;
	}

	public String insertpublish() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Date date = new Date();
		Custom cus = (Custom) ActionContext.getContext().getSession()
				.get("cus");
		String publishMassqge = request.getParameter("publishMassqge");
		publish =  new Publish(cus,publishMassqge, date);
		System.out.println(publish);
		boolean flag = publishService.insertPublish(publish);
		return flag == true ? SUCCESS : ERROR;
	}

	public String publishlist() throws Exception {
		plist = publishService.getAllPublish();
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
