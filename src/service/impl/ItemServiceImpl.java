package service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ItemsDao;
import pojo.Custom;
import pojo.Items;
import service.ItemService;

public class ItemServiceImpl implements ItemService {
	private ItemsDao itemsdao;
	
	

	public ItemsDao getItemsdao() {
		return itemsdao;
	}



	public void setItemsdao(ItemsDao itemsdao) {
		this.itemsdao = itemsdao;
	}



	@Override
	public void additemorder(Items items) {
		itemsdao.save(items);

	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Items> getAllItems(Custom custom) {
		List<Items> itemslist = itemsdao.findByProperty("custom",custom);
		return itemslist;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Items> getAllDate(String strdate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Items> itemlist = itemsdao.findAll();
		List<Items> itemlist1 = new ArrayList<Items>(); 
		try {
			Date d1 = df.parse(strdate);
			for (Items items : itemlist) {
				Date d2 = df.parse(items.getItemDate().toString());
				long diff = d1.getTime() - d2.getTime();
				long day = diff/(1000*24*24*60);
				if(day > 30)
				{
					itemlist1.add(items);
				}
				
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemlist1;
	}



	@Override
	public List<Items> getDiffDate(String strdate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Items> itemlist = itemsdao.findAll();
		List<Items> itemlist1 = new ArrayList<Items>(); 
		try {
			Date d1 = df.parse(strdate);
			for (Items items : itemlist) {
				Date d2 = df.parse(items.getItemDate().toString());
				long diff = d1.getTime() - d2.getTime();
				long day = diff/(1000*24*24*60);
				if(day <= 7)
				{
					itemlist1.add(items);
				}
				
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemlist1;
	}
}
