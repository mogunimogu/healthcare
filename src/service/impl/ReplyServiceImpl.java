package service.impl;

import java.util.List;

import dao.ReplyDao;
import pojo.Reply;
import service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDao replydao;

	public ReplyDao getReplydao() {
		return replydao;
	}

	public void setReplydao(ReplyDao replydao) {
		this.replydao = replydao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getReplyByPublishId(Integer id) {
		List<Reply> rlist = replydao.findByProperty("publish.publishId", id);
		return rlist;
	}

	@Override
	public boolean insertReply(Reply reply) {
		try {
			replydao.save(reply);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
