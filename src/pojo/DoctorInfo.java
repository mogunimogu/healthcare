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
 * DoctorInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "doctor_info", catalog = "healthcare")
public class DoctorInfo implements java.io.Serializable {

	// Fields

	private Integer doctorId;
	private Custom custom;
	private String doctorImg;
	private String doctorName;
	private Integer doctorAge;
	private String doctorRank;
	private String doctorSkill;
	private String doctorTime;
	private Set<DoctorSubscribe> doctorSubscribes = new HashSet<DoctorSubscribe>(
			0);
	private Set<CustomSubscribe> customSubscribes = new HashSet<CustomSubscribe>(
			0);

	// Constructors

	/** default constructor */
	public DoctorInfo() {
	}

	/** minimal constructor */
	public DoctorInfo(Custom custom, String doctorImg, String doctorName,
			Integer doctorAge, String doctorRank, String doctorSkill,
			String doctorTime) {
		this.custom = custom;
		this.doctorImg = doctorImg;
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.doctorRank = doctorRank;
		this.doctorSkill = doctorSkill;
		this.doctorTime = doctorTime;
	}

	/** full constructor */
	public DoctorInfo(Custom custom, String doctorImg, String doctorName,
			Integer doctorAge, String doctorRank, String doctorSkill,
			String doctorTime, Set<DoctorSubscribe> doctorSubscribes,
			Set<CustomSubscribe> customSubscribes) {
		this.custom = custom;
		this.doctorImg = doctorImg;
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.doctorRank = doctorRank;
		this.doctorSkill = doctorSkill;
		this.doctorTime = doctorTime;
		this.doctorSubscribes = doctorSubscribes;
		this.customSubscribes = customSubscribes;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "doctor_id", unique = true, nullable = false)
	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custom_id", nullable = false)
	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	@Column(name = "doctor_img", nullable = false, length = 100)
	public String getDoctorImg() {
		return this.doctorImg;
	}

	public void setDoctorImg(String doctorImg) {
		this.doctorImg = doctorImg;
	}

	@Column(name = "doctor_name", nullable = false, length = 20)
	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Column(name = "doctor_age", nullable = false)
	public Integer getDoctorAge() {
		return this.doctorAge;
	}

	public void setDoctorAge(Integer doctorAge) {
		this.doctorAge = doctorAge;
	}

	@Column(name = "doctor_rank", nullable = false, length = 20)
	public String getDoctorRank() {
		return this.doctorRank;
	}

	public void setDoctorRank(String doctorRank) {
		this.doctorRank = doctorRank;
	}

	@Column(name = "doctor_skill", nullable = false, length = 20)
	public String getDoctorSkill() {
		return this.doctorSkill;
	}

	public void setDoctorSkill(String doctorSkill) {
		this.doctorSkill = doctorSkill;
	}

	@Column(name = "doctor_time", nullable = false, length = 20)
	public String getDoctorTime() {
		return this.doctorTime;
	}

	public void setDoctorTime(String doctorTime) {
		this.doctorTime = doctorTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctorInfo")
	public Set<DoctorSubscribe> getDoctorSubscribes() {
		return this.doctorSubscribes;
	}

	public void setDoctorSubscribes(Set<DoctorSubscribe> doctorSubscribes) {
		this.doctorSubscribes = doctorSubscribes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctorInfo")
	public Set<CustomSubscribe> getCustomSubscribes() {
		return this.customSubscribes;
	}

	public void setCustomSubscribes(Set<CustomSubscribe> customSubscribes) {
		this.customSubscribes = customSubscribes;
	}

}