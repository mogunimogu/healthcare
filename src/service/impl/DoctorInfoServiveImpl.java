package service.impl;

import java.util.List;

import dao.DoctorInfoDao;
import pojo.DoctorInfo;
import service.DoctorInfoServive;

public class DoctorInfoServiveImpl implements DoctorInfoServive {
	
	private DoctorInfoDao doctorinfodao;

	public DoctorInfoDao getDoctorinfodao() {
		return doctorinfodao;
	}

	public void setDoctorinfodao(DoctorInfoDao doctorinfodao) {
		this.doctorinfodao = doctorinfodao;
	}

	@SuppressWarnings("unchecked")
	@Override
	//得到医生信息
	public List<DoctorInfo> showDoctorinfo() {
		List<DoctorInfo> listdoctor = doctorinfodao.findAll();
		return listdoctor;
	}

	@Override
	//增加信息
	public boolean insertDoctorlist(DoctorInfo doctorinfo) {
		try{
		doctorinfodao.save(doctorinfo);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public DoctorInfo getDoctorById(int id){
		return doctorinfodao.findById(id);
	}
	
}
