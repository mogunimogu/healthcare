package pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Consume entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "consume", catalog = "healthcare")
public class Consume implements java.io.Serializable {

	// Fields

	private Integer consumeId;
	private PersonInfo personInfo;
	private Double consumeEnergy;
	private Date daily;

	// Constructors

	/** default constructor */
	public Consume() {
	}

	/** full constructor */
	public Consume(PersonInfo personInfo, Double consumeEnergy, Date daily) {
		this.personInfo = personInfo;
		this.consumeEnergy = consumeEnergy;
		this.daily = daily;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "consume_id", unique = true, nullable = false)
	public Integer getConsumeId() {
		return this.consumeId;
	}

	public void setConsumeId(Integer consumeId) {
		this.consumeId = consumeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perinfo_id", nullable = false)
	public PersonInfo getPersonInfo() {
		return this.personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	@Column(name = "consume_energy", nullable = false, precision = 10)
	public Double getConsumeEnergy() {
		return this.consumeEnergy;
	}

	public void setConsumeEnergy(Double consumeEnergy) {
		this.consumeEnergy = consumeEnergy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "daily", nullable = false, length = 0)
	public Date getDaily() {
		return this.daily;
	}

	public void setDaily(Date daily) {
		this.daily = daily;
	}

}