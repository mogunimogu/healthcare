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
 * Reply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reply", catalog = "healthcare")
public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private Custom custom;
	private Publish publish;
	private String replyMassage;
	private Date replyDate;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(Custom custom, Publish publish, String replyMassage,
			Date replyDate) {
		this.custom = custom;
		this.publish = publish;
		this.replyMassage = replyMassage;
		this.replyDate = replyDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "reply_id", unique = true, nullable = false)
	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "custom_id", nullable = false)
	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publish_id", nullable = false)
	public Publish getPublish() {
		return this.publish;
	}

	public void setPublish(Publish publish) {
		this.publish = publish;
	}

	@Column(name = "reply_massage", nullable = false, length = 200)
	public String getReplyMassage() {
		return this.replyMassage;
	}

	public void setReplyMassage(String replyMassage) {
		this.replyMassage = replyMassage;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reply_date", nullable = false, length = 0)
	public Date getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

}