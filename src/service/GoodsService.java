package service;

import java.util.List;

import pojo.Goods;

public interface GoodsService {
	//根据id获取商品
	public Goods getById(int id);
	
	public List<Goods> getAllGoods();

}
