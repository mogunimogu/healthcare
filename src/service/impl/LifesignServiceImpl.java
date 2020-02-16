package service.impl;

import java.util.List;

import dao.LifesignDao;
import pojo.Lifesign;
import pojo.PersonInfo;
import service.LifesignService;

public class LifesignServiceImpl implements LifesignService {
	private LifesignDao lifesigndao;
	
	public LifesignDao getLifesigndao() {
		return lifesigndao;
	}

	public void setLifesigndao(LifesignDao lifesigndao) {
		this.lifesigndao = lifesigndao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Lifesign getLifesignByPersoninfo(PersonInfo personinfo) {
		List<Lifesign> lifelist = lifesigndao.findByProperty("personInfo", personinfo);
		if(lifelist.size()>0)
		{
			return lifelist.get(0);
		}
		return null;
	}

}
