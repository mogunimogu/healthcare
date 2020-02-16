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
	 * 根据id获取商品方法
	 */
	public Goods getById(int id) {
		Goods good = gooddao.findById(id);
		return good;
	}
   
	/**
	 * 获取所有商品方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> getAllGoods() {
		List<Goods> goodlist = gooddao.findAll();
		return goodlist;
	}

}
