package service;

import java.util.List;

import pojo.CustomSubscribe;
import pojo.DoctorInfo;

public interface CustomSubscribeSerivce {
	//��ȡ����ֵ
	public List<CustomSubscribe> showlistcustoms();
	//���Ӷ���
	public boolean addcustomsubscrive(CustomSubscribe customsubscribe);
	//ɾ������
	public boolean deletesubscrive(CustomSubscribe customsubscribe);
	//��ȡID
	public CustomSubscribe getCustomSubscribeById(Integer CustomSubscribeid);
	
	public DoctorInfo getDoctorinfoById(Integer doctorinfoid);
}
