package action;

import java.util.List;

import pojo.Publish;
import pojo.Reply;
import service.CustomService;
import service.PublishService;
import service.ReplyService;
import service.SupportService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class showReplyAction implements Action {
	private ReplyService replyService;
	private PublishService publishService;
	private SupportService supportService;
	private Integer publishId;
	private List<Reply> rlist;
	
	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	public SupportService getSupportService() {
		return supportService;
	}

	public void setSupportService(SupportService supportService) {
		this.supportService = supportService;
	}

	public Integer getPublishId() {
		return publishId;
	}

	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}

	public List<Reply> getRlist() {
		return rlist;
	}

	public void setRlist(List<Reply> rlist) {
		this.rlist = rlist;
	}

	public String show() throws Exception {
		rlist =	replyService.getReplyByPublishId(publishId);
		Integer count =	supportService.getCount();
		ActionContext.getContext().getSession().put("count", count);
		Publish publish = 	publishService.getPublishById(publishId);
		ActionContext.getContext().getSession().put("publish", publish);
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
