package service.impl;

import java.util.List;

import dao.PersonInfoDao;
import pojo.Custom;
import pojo.PersonInfo;
import service.PersonInfoService;

public class PersonInfoServiceImpl implements PersonInfoService {
	private PersonInfoDao persondao;
	
	

	public PersonInfoDao getPersondao() {
		return persondao;
	}



	public void setPersondao(PersonInfoDao persondao) {
		this.persondao = persondao;
	}



	@SuppressWarnings("unchecked")
	@Override
	public PersonInfo getPersonByName(Custom custom) {
		List<PersonInfo> personinfolist = (List<PersonInfo>) persondao.findByProperty("custom", custom);
		if(personinfolist.size()>0)
		{
			return personinfolist.get(0);
		}
		return null;
		
	}

}
