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
 * Support entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "support", catalog = "healthcare")
public class Support implements java.io.Serializable {

	// Fields

	private Integer supportId;
	private Custom custom;
	private Publish publish;
	private Integer supportNum;
	private Date supportDate;

	// Constructors

	/** default constructor */
	public Support() {
	}

	/** full constructor */
	public Support(Custom custom, Publish publish, Integer supportNum,
			Date supportDate) {
		this.custom = custom;
		this.publish = publish;
		this.supportNum = supportNum;
		this.supportDate = supportDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "support_id", unique = true, nullable = false)
	public Integer getSupportId() {
		return this.supportId;
	}

	public void setSupportId(Integer supportId) {
		this.supportId = supportId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custom_id", nullable = false)
	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publish_id", nullable = false)
	public Publish getPublish() {
		return this.publish;
	}

	public void setPublish(Publish publish) {
		this.publish = publish;
	}

	@Column(name = "support_num", nullable = false)
	public Integer getSupportNum() {
		return this.supportNum;
	}

	public void setSupportNum(Integer supportNum) {
		this.supportNum = supportNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "support_date", nullable = false, length = 0)
	public Date getSupportDate() {
		return this.supportDate;
	}

	public void setSupportDate(Date supportDate) {
		this.supportDate = supportDate;
	}

	@Override
	public String toString() {
		return "Support [supportId=" + supportId + ", custom=" + custom
				+ ", publish=" + publish + ", supportNum=" + supportNum
				+ ", supportDate=" + supportDate + "]";
	}
	
}