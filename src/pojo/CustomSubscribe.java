package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * CustomSubscribe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "custom_subscribe", catalog = "healthcare")
public class CustomSubscribe implements java.io.Serializable {

	// Fields

	private Integer subscribeId;
	private DoctorInfo doctorInfo;
	private String subscribeDate;
	private String customName;
	private Set<DoctorSubscribe> doctorSubscribes = new HashSet<DoctorSubscribe>(
			0);

	// Constructors

	/** default constructor */
	public CustomSubscribe() {
	}

	/** minimal constructor */
	public CustomSubscribe(DoctorInfo doctorInfo, String subscribeDate,
			String customName) {
		this.doctorInfo = doctorInfo;
		this.subscribeDate = subscribeDate;
		this.customName = customName;
	}

	/** full constructor */
	public CustomSubscribe(DoctorInfo doctorInfo, String subscribeDate,
			String customName, Set<DoctorSubscribe> doctorSubscribes) {
		this.doctorInfo = doctorInfo;
		this.subscribeDate = subscribeDate;
		this.customName = customName;
		this.doctorSubscribes = doctorSubscribes;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "subscribe_id", unique = true, nullable = false)
	public Integer getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(Integer subscribeId) {
		this.subscribeId = subscribeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false)
	public DoctorInfo getDoctorInfo() {
		return this.doctorInfo;
	}

	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}

	@Column(name = "subscribe_date", nullable = false, length = 20)
	public String getSubscribeDate() {
		return this.subscribeDate;
	}

	public void setSubscribeDate(String subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	@Column(name = "custom_name", nullable = false, length = 20)
	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customSubscribe")
	public Set<DoctorSubscribe> getDoctorSubscribes() {
		return this.doctorSubscribes;
	}

	public void setDoctorSubscribes(Set<DoctorSubscribe> doctorSubscribes) {
		this.doctorSubscribes = doctorSubscribes;
	}

}