package service;

import java.util.List;

import pojo.Publish;
import pojo.Reply;

public interface ReplyService {
	public List<Reply> getReplyByPublishId(Integer id);
	public boolean insertReply(Reply reply);
}
