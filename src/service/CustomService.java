package service;


import pojo.Custom;

public interface CustomService {
	//ע���û������ӿ�
	public void registerCustom(Custom custom);
	//��¼�����ӿ�
	public Custom login(String name,String password);
	
	//�ж��û��Ƿ����
	
	public Custom  isByName(String name);


}
