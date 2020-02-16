package service;

import java.util.List;

import pojo.Custom;
import pojo.Items;

public interface ItemService {
	public void additemorder(Items items);
	
	public List<Items> getAllItems(Custom custom);
	
	public List<Items> getAllDate(String strdate);
	
	public List<Items> getDiffDate(String strdate);

}
