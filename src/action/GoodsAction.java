package action;

import java.util.List;

import pojo.Custom;
import pojo.Goods;
import service.GoodsService;
import service.ShoppingCartService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {
	 private GoodsService goodservice;
	 private ShoppingCartService shopcartservice;

	public ShoppingCartService getShopcartservice() {
		return shopcartservice;
	}

	public void setShopcartservice(ShoppingCartService shopcartservice) {
		this.shopcartservice = shopcartservice;
	}

	public GoodsService getGoodservice() {
		return goodservice;
	}

	public void setGoodservice(GoodsService goodservice) {
		this.goodservice = goodservice;
	}

	@Override
	public String execute() throws Exception {
		
		return super.execute();
	}
	
	public String getAllGoods() throws Exception{
		List<Goods> goodlist = goodservice.getAllGoods();
		ActionContext.getContext().getSession().put("goodlist", goodlist);
		Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
		int counts = shopcartservice.getCountShop(custom.getCustomId());
		ActionContext.getContext().getSession().put("counts", counts);
		return SUCCESS;
	}
	 
	 
	 

}
