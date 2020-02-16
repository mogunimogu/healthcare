package service;

import java.util.List;

import pojo.CustomSubscribe;
import pojo.DoctorInfo;

public interface CustomSubscribeSerivce {
	//获取所有值
	public List<CustomSubscribe> showlistcustoms();
	//增加订单
	public boolean addcustomsubscrive(CustomSubscribe customsubscribe);
	//删除订单
	public boolean deletesubscrive(CustomSubscribe customsubscribe);
	//获取ID
	public CustomSubscribe getCustomSubscribeById(Integer CustomSubscribeid);
	
	public DoctorInfo getDoctorinfoById(Integer doctorinfoid);
}
