package test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomDao;
import pojo.Custom;
import pojo.Goodstype;
import service.GoodsService;
import service.GoodsTypeService;


public class Test01 {
	@Test
	public void show()
	{
		try{
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			GoodsService CustomService = (GoodsService) ctx.getBean("goodsservice");
			System.out.println(CustomService);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void show01()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsTypeService gts = (GoodsTypeService) ctx.getBean("goodstypeservice");
		List<Goodstype> gtlist = (List<Goodstype>) gts.getAllGoodType();
		for (Goodstype goodstype : gtlist) {
			System.out.println(goodstype);
		}


		System.out.println();
	}
	
	@Test
	public void show02()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomDao gts = (CustomDao) ctx.getBean("CustomDAO");
		List<Custom> cuslist = gts.findAll();
		for (Custom custom : cuslist) {
			System.out.print(custom.getShoppingCarts());
		}
		
	}
	@Test
	public void datecha(){
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       try{
    	   Date date1 = df.parse("2004-03-26 13:31:40");
    	   Date date2 = df.parse("2015-12-20:30:24");
    	   long diff = date1.getTime() - date2.getTime();
    	   System.out.println(diff);
    	   long day = diff/(1000*60*60*24);
    	   System.out.println(day);
       }
       catch(Exception ex){
    	   
       }
		
	}
}
