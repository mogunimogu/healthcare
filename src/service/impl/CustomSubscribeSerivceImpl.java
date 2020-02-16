package service.impl;

import java.util.List;

import dao.CustomSubscribeDao;
import dao.DoctorInfoDao;
import pojo.CustomSubscribe;
import pojo.DoctorInfo;
import service.CustomSubscribeSerivce;

public class CustomSubscribeSerivceImpl implements CustomSubscribeSerivce {

	private CustomSubscribeDao customsdao;
	private DoctorInfoDao doctorinfodao;
	

	public DoctorInfoDao getDoctorinfodao() {
		return doctorinfodao;
	}

	public void setDoctorinfodao(DoctorInfoDao doctorinfodao) {
		this.doctorinfodao = doctorinfodao;
	}

	public CustomSubscribeDao getCustomsdao() {
		return customsdao;
	}

	public void setCustomsdao(CustomSubscribeDao customsdao) {
		this.customsdao = customsdao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomSubscribe> showlistcustoms() {
		List<CustomSubscribe> listcustoms = customsdao.findAll();
		return listcustoms;
	}

	@Override
	public boolean addcustomsubscrive(CustomSubscribe customsubscribe) {
		try {
			customsdao.save(customsubscribe);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	@Override
	public boolean deletesubscrive(CustomSubscribe customsubscribe) {
		try {
			customsdao.delete(customsubscribe);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CustomSubscribe getCustomSubscribeById(Integer CustomSubscribeid) {
		return customsdao.findById(CustomSubscribeid);
	}

	@Override
	public DoctorInfo getDoctorinfoById(Integer doctorinfoid) {
		return doctorinfodao.findById(doctorinfoid);
	}
}
