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
 * DoctorSubscribe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "doctor_subscribe", catalog = "healthcare")
public class DoctorSubscribe implements java.io.Serializable {

	// Fields

	private Integer doctorSubscribeId;
	private CustomSubscribe customSubscribe;
	private DoctorInfo doctorInfo;

	// Constructors

	/** default constructor */
	public DoctorSubscribe() {
	}

	/** full constructor */
	public DoctorSubscribe(CustomSubscribe customSubscribe,
			DoctorInfo doctorInfo) {
		this.customSubscribe = customSubscribe;
		this.doctorInfo = doctorInfo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "doctor_subscribe_id", unique = true, nullable = false)
	public Integer getDoctorSubscribeId() {
		return this.doctorSubscribeId;
	}

	public void setDoctorSubscribeId(Integer doctorSubscribeId) {
		this.doctorSubscribeId = doctorSubscribeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscribe_id", nullable = false)
	public CustomSubscribe getCustomSubscribe() {
		return this.customSubscribe;
	}

	public void setCustomSubscribe(CustomSubscribe customSubscribe) {
		this.customSubscribe = customSubscribe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false)
	public DoctorInfo getDoctorInfo() {
		return this.doctorInfo;
	}

	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}

}