package action;

import java.util.List;

import pojo.Custom;
import pojo.CustomSubscribe;
import pojo.DoctorInfo;
import service.CustomSubscribeSerivce;
import service.DoctorInfoServive;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DoctorInfoDao;

public class DoctorInfoAction extends ActionSupport {
	private DoctorInfoServive doctorinfoservice;
	private DoctorInfo doctorinfo;
	private DoctorInfoDao doctorinfodao;
	private List<DoctorInfo> dlist;
	private List<CustomSubscribe> listcusto;
	private CustomSubscribeSerivce customdoctorserivce;
	private CustomSubscribe customSubscribe;
	private Integer customsubscribeid;
	
	
	public CustomSubscribe getCustomSubscribe() {
		return customSubscribe;
	}

	public void setCustomSubscribe(CustomSubscribe customSubscribe) {
		this.customSubscribe = customSubscribe;
	}

	public Integer getCustomsubscribeid() {
		return customsubscribeid;
	}

	public void setCustomsubscribeid(Integer customsubscribeid) {
		this.customsubscribeid = customsubscribeid;
	}

	public List<CustomSubscribe> getListcusto() {
		return listcusto;
	}

	public void setListcusto(List<CustomSubscribe> listcusto) {
		this.listcusto = listcusto;
	}

	public CustomSubscribeSerivce getCustomdoctorserivce() {
		return customdoctorserivce;
	}

	public void setCustomdoctorserivce(CustomSubscribeSerivce customdoctorserivce) {
		this.customdoctorserivce = customdoctorserivce;
	}

	public DoctorInfoDao getDoctorinfodao() {
		return doctorinfodao;
	}

	public void setDoctorinfodao(DoctorInfoDao doctorinfodao) {
		this.doctorinfodao = doctorinfodao;
	}

	public DoctorInfo getDoctorinfo() {
		return doctorinfo;
	}

	public void setDoctorinfo(DoctorInfo doctorinfo) {
		this.doctorinfo = doctorinfo;
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

	/**
	 * 增加医生基础信息
	 * @return 返回增加是否正确
	 * @throws Exception
	 */
	public String insertdoctorinfo() throws Exception {
		boolean flag = doctorinfoservice.insertDoctorlist(doctorinfo);
		return flag == true?SUCCESS:ERROR;
	}
	/*显示医生信息*/
	public String showdoctorinfo(){	
		 dlist = doctorinfoservice.showDoctorinfo();
		 listcusto = customdoctorserivce.showlistcustoms();
		 /*ActionContext.getContext().getSession().put("doctorinfo", doctorlist);
			ActionContext.getContext().getSession().get("cus");*/
			//System.out.println(dlist);
		return SUCCESS;
	}
}
