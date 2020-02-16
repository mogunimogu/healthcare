package service.impl;

import java.util.List;

import dao.SupportDao;
import pojo.Support;
import service.SupportService;

public class SupportServiceImpl implements SupportService {
	private SupportDao supportdao;

	public SupportDao getSupportdao() {
		return supportdao;
	}

	public void setSupportdao(SupportDao supportdao) {
		this.supportdao = supportdao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCount() {
		List<Support> slist = supportdao.findAll();
		Integer count = slist.size();
		return count;
	}

	@Override
	public boolean insertSupport(Support support) {
		try {
			supportdao.save(support);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
