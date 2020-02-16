package service.impl;

import java.util.List;

import dao.CustomDao;
import pojo.Custom;
import service.CustomService;

public class CustomServiceImpl implements CustomService {
	private CustomDao customdao;

	public void setCustomdao(CustomDao customdao) {
		this.customdao = customdao;
	}

	@Override
	public void registerCustom(Custom custom) {
		customdao.save(custom);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Custom login(String name, String password) {
		List<Custom> customlist = customdao.findAll();
		for (Custom custom : customlist) {
			if(custom.getCustomName().trim().equals(name) && custom.getCustomPwd().trim().equals(password))
			{
				return custom;
			}
		}
		return null;
	}

	@Override
	public Custom isByName(String name) {
		List<Custom> customlist = customdao.findAll();
		for (Custom custom : customlist) {
			if(custom.getCustomName().trim().equals(name))
			{
				return custom;
			}
		}
		return null;
	}
	

}
