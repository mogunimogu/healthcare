package action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import pojo.CustomSubscribe;
import pojo.DoctorInfo;
import service.CustomSubscribeSerivce;
import service.DoctorInfoServive;

import com.opensymphony.xwork2.ActionSupport;

import dao.DoctorInfoDao;

public class CustomSubscribeAction extends ActionSupport {
	private CustomSubscribeSerivce customdoctorserivce;
	private List<CustomSubscribe> listcusto;
	private CustomSubscribe customSubscribe;
	private DoctorInfoServive doctorinfoservice;
	private List<DoctorInfo> dlist;
	private DoctorInfo doctorinfo;
	private Integer customsubscribeid;
	private Integer doctorinfobyid;
	private Integer nameId;
	private DoctorInfoDao doctorinfodao;
	private String time;

	public DoctorInfoDao getDoctorinfodao() {
		return doctorinfodao;
	}

	public void setDoctorinfodao(DoctorInfoDao doctorinfodao) {
		this.doctorinfodao = doctorinfodao;
	}

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}

	public DoctorInfo getDoctorinfo() {
		return doctorinfo;
	}

	public void setDoctorinfo(DoctorInfo doctorinfo) {
		this.doctorinfo = doctorinfo;
	}

	public Integer getDoctorinfobyid() {
		return doctorinfobyid;
	}

	public void setDoctorinfobyid(Integer doctorinfobyid) {
		this.doctorinfobyid = doctorinfobyid;
	}

	public Integer getCustomsubscribeid() {
		return customsubscribeid;
	}

	public void setCustomsubscribeid(Integer customsubscribeid) {
		this.customsubscribeid = customsubscribeid;
	}

	public CustomSubscribeSerivce getCustomdoctorserivce() {
		return customdoctorserivce;
	}

	public void setCustomdoctorserivce(
			CustomSubscribeSerivce customdoctorserivce) {
		this.customdoctorserivce = customdoctorserivce;
	}

	public List<CustomSubscribe> getListcusto() {
		return listcusto;
	}

	public void setListcusto(List<CustomSubscribe> listcusto) {
		this.listcusto = listcusto;
	}

	public CustomSubscribe getCustomSubscribe() {
		return customSubscribe;
	}

	public void setCustomSubscribe(CustomSubscribe customSubscribe) {
		this.customSubscribe = customSubscribe;
	}

	public DoctorInfoServive getDoctorinfoservice() {
		return doctorinfoservice;
	}

	public void setDoctorinfoservice(DoctorInfoServive doctorinfoservice) {
		this.doctorinfoservice = doctorinfoservice;
	}

	public List<DoctorInfo> getDlist() {
		return dlist;
	}

	public void setDlist(List<DoctorInfo> dlist) {
		this.dlist = dlist;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	// 获取ID
	public String showById() throws Exception {
		CustomSubscribe cs = customdoctorserivce.getCustomSubscribeById(this
				.getCustomsubscribeid());
		if (cs != null) {
			this.setCustomSubscribe(cs);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String showdoctorById() throws Exception {
		DoctorInfo doctorinfo = doctorinfoservice.getDoctorById(this
				.getCustomsubscribeid());
		if (doctorinfo != null) {
			this.setDoctorinfo(doctorinfo);
			return SUCCESS;
		}
		return ERROR;
	}

	// 订单显示
	public String showcustomdoctors() {
		listcusto = customdoctorserivce.showlistcustoms();
		dlist = doctorinfoservice.showDoctorinfo();
		//System.out.println(listcusto);
		return SUCCESS;
	}

	// 增加订单
	public String addcustomsubscrive() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("addcustomersubscrive方法调用");
			System.err.println("编号：" + this.getDoctorinfobyid());
			DoctorInfo doctor = (DoctorInfo) doctorinfoservice
					.getDoctorById(this.getDoctorinfobyid());
			String time = request.getParameter("customSubscribe.subscribeDate");
			System.err.println("时间:"+time);
			String doctorname = request
					.getParameter("customSubscribe.doctorinfo.getdoctorName");
			System.out.println("医生"+doctorname);
			CustomSubscribe cs = new CustomSubscribe(doctor,time, doctorname);
			customdoctorserivce.addcustomsubscrive(cs);
		return SUCCESS;
}

	// 删除订单
	public String deletesubscrive() throws Exception {
		System.out.println("1111111111111111s");
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer rid = Integer.parseInt(request.getParameter("customSubscribe.subscribeId").toString());
		CustomSubscribe cs = customdoctorserivce.getCustomSubscribeById(rid);
		System.out.println("打印："+ cs);
		boolean flag = customdoctorserivce.deletesubscrive(cs);
		return flag == true ? SUCCESS : ERROR;
	}

}
