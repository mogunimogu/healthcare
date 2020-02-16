package service.impl;

import java.util.List;

import dao.CustomDao;
import dao.PublishDao;
import pojo.Custom;
import pojo.Publish;
import service.PublishService;

public class PublishServiceImpl implements PublishService {
	private PublishDao publishdao;
	private CustomDao customdao;

	public PublishDao getPublishdao() {
		return publishdao;
	}

	public void setPublishdao(PublishDao publishdao) {
		this.publishdao = publishdao;
	}

	public CustomDao getCustomdao() {
		return customdao;
	}

	public void setCustomdao(CustomDao customdao) {
		this.customdao = customdao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publish> getAllPublish() {
		List<Publish> plist = publishdao.findAll();
		return plist;
	}

	@Override
	public boolean insertPublish(Publish publish) {
		try {
			publishdao.save(publish);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Publish getPublishById(Integer id) {
		Publish publish = publishdao.findById(id);
		return publish;
	}
}
