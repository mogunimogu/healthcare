package service;


import pojo.Custom;

public interface CustomService {
	//注册用户方法接口
	public void registerCustom(Custom custom);
	//登录方法接口
	public Custom login(String name,String password);
	
	//判断用户是否存在
	
	public Custom  isByName(String name);


}
