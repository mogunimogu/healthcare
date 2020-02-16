package service.impl;

import java.util.ArrayList;
import java.util.List;

import pojo.Custom;
import pojo.Goods;
import pojo.ShoppingCart;
import dao.ShoppingCartDao;
import service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	private ShoppingCartDao shopcartdao;
	

	public ShoppingCartDao getShopcartdao() {
		return shopcartdao;
	}


	public void setShopcartdao(ShoppingCartDao shopcartdao) {
		this.shopcartdao = shopcartdao;
	}


	@Override
	public void addShopping(ShoppingCart shopcart) {

			shopcartdao.save(shopcart);
	}


	@Override
	public ShoppingCart getShopById(int id) {
		ShoppingCart shopcart = shopcartdao.findById(id);
		return shopcart;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> getListShop(Custom cus) {
		List<ShoppingCart> shoplist = shopcartdao.findByProperty("custom", cus);
		/*List<ShoppingCart> list = new ArrayList<>();
		for (ShoppingCart shoppingCart : shoplist) {
			if(shoppingCart.getCustom().getCustomId().equals(id))
			{
				list.add(shoppingCart);
			}
		}*/
		return shoplist;
	}


	@SuppressWarnings("unchecked")
	@Override
	public int getCountShop(int id) {
		List<ShoppingCart> shoplist = shopcartdao.findAll();
		List<ShoppingCart> list = new ArrayList<>();
		for (ShoppingCart shoppingCart : shoplist) {
			if(shoppingCart.getCustom().getCustomId().equals(id))
			{
                         list.add(shoppingCart);				
			}
		}
		return list.size();
	}


	@Override
	public void delShop(ShoppingCart shopcart) {
		shopcartdao.delete(shopcart);
	}


	@Override
	public void updateShop(ShoppingCart shopcart) {
		shopcartdao.merge(shopcart);
		
	}

}
