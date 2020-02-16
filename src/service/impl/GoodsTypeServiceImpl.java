package service.impl;

import java.util.List;

import pojo.Goodstype;
import dao.GoodstypeDao;
import service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService {
	private GoodstypeDao goodstypedao;

	public GoodstypeDao getGoodstypedao() {
		return goodstypedao;
	}
	
	public void setGoodstypedao(GoodstypeDao goodstypedao) {
		this.goodstypedao = goodstypedao;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ѯ������Ʒ�ķ���
	 */
	public List<Goodstype> getAllGoodType() {
		
		List<Goodstype> gtlist = goodstypedao.findAll();
		return gtlist;
	}

}
