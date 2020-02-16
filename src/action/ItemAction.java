package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import pojo.Custom;
import pojo.Items;
import pojo.ShoppingCart;
import service.ItemService;
import service.ShoppingCartService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport {
	private ItemService itemservice;
	private ShoppingCartService shopcartService;
	private List<Integer> listshopid;
	private List<Integer> listcount;
	private List<Double> listprice;
	private String shopid;
     

	public String getShopid() {
		return shopid;
	}



	public void setShopid(String shopid) {
		this.shopid = shopid;
	}



	public List<Double> getListprice() {
		return listprice;
	}



	public void setListprice(List<Double> listprice) {
		this.listprice = listprice;
	}



	public List<Integer> getListcount() {
		return listcount;
	}



	public void setListcount(List<Integer> listcount) {
		this.listcount = listcount;
	}



	public List<Integer> getListshopid() {
		return listshopid;
	}



	public void setListshopid(List<Integer> listshopid) {
		this.listshopid = listshopid;
	}


	public ItemService getItemservice() {
		return itemservice;
	}



	public void setItemservice(ItemService itemservice) {
		this.itemservice = itemservice;
	}
	
	



	public ShoppingCartService getShopcartService() {
		return shopcartService;
	}



	public void setShopcartService(ShoppingCartService shopcartService) {
		this.shopcartService = shopcartService;
	}



	@Override
	public String execute() throws Exception {
	Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
    for(int i=0; i<listshopid.size();i++)
    {
    	System.out.println(listshopid.get(i));
    	ShoppingCart shopcart = shopcartService.getShopById(listshopid.get(i));
    	System.out.println(shopcart);
    	Date date = new Date();
    	Items items1 = new Items(custom, shopcart.getGoods(), listcount.get(i), listprice.get(i), date);
    	//System.out.println(items.getItemPrice());
    	itemservice.additemorder(items1);
    	shopcartService.delShop(shopcart);
    }
		return SUCCESS;
	}
	
	public String getAllItems() throws Exception{
		Custom custom = (Custom) ActionContext.getContext().getSession().get("cus");
		List<Items> itemslist = itemservice.getAllItems(custom);
		ActionContext.getContext().getSession().put("itemlist",itemslist);
		return SUCCESS;
	}
	
	public String  delshop() throws Exception
	{
     System.out.println(shopid);
     String [] strArray = shopid.split(",");
     if(!shopid.equals("")){
    	 for(int i=0;i<strArray.length;i++){
        	 int pid = Integer.parseInt(strArray[i]);
        	 ShoppingCart shopcart = shopcartService.getShopById(pid);
    			shopcartService.delShop(shopcart);
         }
     }
     
     return SUCCESS;
		/*System.out.println("数组长度:"+shopid.length);
	System.out.println("111111111111111111111111");
		if(shopid[0]!=null)
		{
				for(int i=0;i<shopid.length;i++){
					ShoppingCart shopcart = shopcartService.getShopById(shopid[i]);
					shopcartService.delShop(shopcart);
			}
		}
	*/		
	}
	
	public String dateafter() throws Exception{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Items> itemlist = itemservice.getAllDate(df.format(date));
		ActionContext.getContext().getSession().put("itemlist", itemlist);
		return SUCCESS;
	}
	
	public String datediffday() throws Exception{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Items> itemlist = itemservice.getDiffDate(df.format(date));
		ActionContext.getContext().getSession().put("itemlist", itemlist);
		return SUCCESS;
	}

}
