package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Lifesign entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lifesign", catalog = "healthcare")
public class Lifesign implements java.io.Serializable {

	// Fields

	private Integer signId;
	private PersonInfo personInfo;
	private Integer bloodpressureL;
	private Integer bloodpressureH;
	private Double glucose;
	private Integer heartrate;
	private String samplingtime;

	// Constructors

	/** default constructor */
	public Lifesign() {
	}

	/** full constructor */
	public Lifesign(PersonInfo personInfo, Integer bloodpressureL,
			Integer bloodpressureH, Double glucose, Integer heartrate,
			String samplingtime) {
		this.personInfo = personInfo;
		this.bloodpressureL = bloodpressureL;
		this.bloodpressureH = bloodpressureH;
		this.glucose = glucose;
		this.heartrate = heartrate;
		this.samplingtime = samplingtime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "sign_id", unique = true, nullable = false)
	public Integer getSignId() {
		return this.signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perinfo_id", nullable = false)
	public PersonInfo getPersonInfo() {
		return this.personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	@Column(name = "bloodpressure-L", nullable = false)
	public Integer getBloodpressureL() {
		return this.bloodpressureL;
	}

	public void setBloodpressureL(Integer bloodpressureL) {
		this.bloodpressureL = bloodpressureL;
	}

	@Column(name = "bloodpressure-H", nullable = false)
	public Integer getBloodpressureH() {
		return this.bloodpressureH;
	}

	public void setBloodpressureH(Integer bloodpressureH) {
		this.bloodpressureH = bloodpressureH;
	}

	@Column(name = "glucose", nullable = false, precision = 10)
	public Double getGlucose() {
		return this.glucose;
	}

	public void setGlucose(Double glucose) {
		this.glucose = glucose;
	}

	@Column(name = "heartrate", nullable = false)
	public Integer getHeartrate() {
		return this.heartrate;
	}

	public void setHeartrate(Integer heartrate) {
		this.heartrate = heartrate;
	}

	@Column(name = "samplingtime", nullable = false, length = 40)
	public String getSamplingtime() {
		return this.samplingtime;
	}

	public void setSamplingtime(String samplingtime) {
		this.samplingtime = samplingtime;
	}

}