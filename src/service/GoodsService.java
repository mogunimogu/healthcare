package service;

import java.util.List;

import pojo.Goods;

public interface GoodsService {
	//����id��ȡ��Ʒ
	public Goods getById(int id);
	
	public List<Goods> getAllGoods();

}
