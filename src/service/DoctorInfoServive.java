package service;

import java.util.List;

import pojo.DoctorInfo;

public interface DoctorInfoServive {
	//获取角色所有信息
	public List<DoctorInfo> showDoctorinfo();
	//增加角色信息
	public boolean insertDoctorlist(DoctorInfo doctorinfo);
	
	public DoctorInfo getDoctorById(int id);
}
