package action;

import java.util.Date;

import pojo.Custom;
import pojo.Publish;
import pojo.Support;
import service.PublishService;
import service.SupportService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SupportAction implements Action {
	private SupportService supportservice;
	private PublishService publishService;
	private Support support;
	private Integer count;
	private Publish publish;
	private Integer publishId;
	public SupportService getSupportservice() {
		return supportservice;
	}

	public void setSupportservice(SupportService supportservice) {
		this.supportservice = supportservice;
	}
	
	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Publish getPublish() {
		return publish;
	}

	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	
	
	public Integer getPublishId() {
		return publishId;
	}

	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}

	public String insertsupport() throws Exception {
		System.out.println(publishId);
		Date date = new Date();
		Custom cus = (Custom) ActionContext.getContext().getSession().get("cus");
		Publish publish1 = publishService.getPublishById(publishId);
		System.out.println(publish1);
		Support s = new Support(cus, publish1, 1, date);
		boolean flag = supportservice.insertSupport(s);
		System.out.println(flag);
		return flag == true ? SUCCESS : ERROR;
	}

	public String supportcount() throws Exception {
		count = supportservice.getCount();
		ActionContext.getContext().put("count", count);
		return count >= 1 ? SUCCESS : ERROR;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
