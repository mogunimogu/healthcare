package service;

import java.util.List;

import pojo.DoctorInfo;

public interface DoctorInfoServive {
	//��ȡ��ɫ������Ϣ
	public List<DoctorInfo> showDoctorinfo();
	//���ӽ�ɫ��Ϣ
	public boolean insertDoctorlist(DoctorInfo doctorinfo);
	
	public DoctorInfo getDoctorById(int id);
}
