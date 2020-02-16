package action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import pojo.Custom;
import pojo.Publish;
import pojo.Reply;
import service.PublishService;
import service.ReplyService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ReplyAction implements Action {
	private ReplyService replyService;
	private PublishService publishService;
	private Publish publish;
	private Custom custom;
	private Reply reply;
	private List<Reply> rlist;
	private String publishId;
	
	public String getPublishId() {
		return publishId;
	}

	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}

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

	public List<Reply> getRlist() {
		return rlist;
	}

	public void setRlist(List<Reply> rlist) {
		this.rlist = rlist;
	}

	public Publish getPublish() {
		return publish;
	}

	public void setPublish(Publish publish) {
		this.publish = publish;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
	public String insertReply() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String replyMassage = request.getParameter("replyMassage");
		System.out.println(replyMassage);
		Integer publishId1 = Integer.parseInt(this.publishId);
		System.out.println(publishId1);
		Date date = new Date();
		Custom cus = (Custom) ActionContext.getContext().getSession().get("cus");
		Publish pub = publishService.getPublishById(publishId1);
		Reply r= new Reply(cus, pub, replyMassage, date);
		boolean flag = replyService.insertReply(r);
		return flag == true ? SUCCESS : ERROR;
	}

	public String Replylist() throws Exception {
		rlist = replyService.getReplyByPublishId(publish.getPublishId());
		return rlist != null ? SUCCESS : ERROR;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
