package service.impl;

import java.util.List;

import pojo.Goods;
import dao.GoodsDao;
import service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	private GoodsDao gooddao;
	
   
	public GoodsDao getGooddao() {
		return gooddao;
	}

	public void setGooddao(GoodsDao gooddao) {
		this.gooddao = gooddao;
	}

	@Override
	/**
	 * ����id��ȡ��Ʒ����
	 */
	public Goods getById(int id) {
		Goods good = gooddao.findById(id);
		return good;
	}
   
	/**
	 * ��ȡ������Ʒ����
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> getAllGoods() {
		List<Goods> goodlist = gooddao.findAll();
		return goodlist;
	}

}
