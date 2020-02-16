package action;

import java.util.List;

import pojo.Custom;
import pojo.Goods;
import pojo.ShoppingCart;
import service.GoodsService;
import service.ShoppingCartService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport {
	private ShoppingCartService shopcartservice;
	private ShoppingCart shopcart;
	private GoodsService goodservice;


	public GoodsService getGoodservice() {
		return goodservice;
	}

	public void setGoodservice(GoodsService goodservice) {
		this.goodservice = goodservice;
	}

	public ShoppingCart getShopcart() {
		return shopcart;
	}

	public void setShopcart(ShoppingCart shopcart) {
		this.shopcart = shopcart;
	}

	public ShoppingCartService getShopcartservice() {
		return shopcartservice;
	}

	public void setShopcartservice(ShoppingCartService shopcartservice) {
		this.shopcartservice = shopcartservice;
	}
	
	public String addShop() throws Exception{
		System.out.println(1);
		Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
		Goods goods = goodservice.getById(shopcart.getGoods().getGoodsId());
			ShoppingCart shopcart1 = new ShoppingCart(custom, goods, shopcart.getSCount(),goods.getGoodsPrice());
			shopcartservice.addShopping(shopcart1);
			return SUCCESS;
	}
	
	public String delShopById() throws Exception{
		goodservice.getById(shopcart.getSid());
		return SUCCESS;
	}
	
	public String listshop() throws Exception{
		Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
		System.out.println(custom.getCustomId());
		List<ShoppingCart> listshop = (List<ShoppingCart>) shopcartservice.getListShop(custom);
		ActionContext.getContext().getSession().put("listshop", listshop);
		for (ShoppingCart shoppingCart : listshop) {
			System.out.println(shoppingCart );
		}
		return SUCCESS;
	}
	

}
