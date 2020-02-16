package service;

import java.util.List;

import pojo.Custom;
import pojo.Goods;
import pojo.ShoppingCart;

public interface ShoppingCartService {
	public void addShopping(ShoppingCart shopcart);
	
	public ShoppingCart getShopById(int id);
	
	public List<ShoppingCart> getListShop(Custom cus);
	
	public int getCountShop(int id);
	
	public void delShop(ShoppingCart shopcart);
	
	public void updateShop(ShoppingCart shopcart);

}
