package pojo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Publish entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publish", catalog = "healthcare")
public class Publish implements java.io.Serializable {

	// Fields

	private Integer publishId;
	private Custom custom;
	private String publishMassqge;
	private Date publishDate;
	private Set<Support> supports = new HashSet<Support>(0);
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Publish() {
	}

	/** minimal constructor */
	public Publish(Custom custom, String publishMassqge, Date publishDate) {
		this.custom = custom;
		this.publishMassqge = publishMassqge;
		this.publishDate = publishDate;
	}

	/** full constructor */
	public Publish(Custom custom, String publishMassqge, Date publishDate,
			Set<Support> supports, Set<Reply> replies) {
		this.custom = custom;
		this.publishMassqge = publishMassqge;
		this.publishDate = publishDate;
		this.supports = supports;
		this.replies = replies;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "publish_id", unique = true, nullable = false)
	public Integer getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "custom_id", nullable = false)
	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	@Column(name = "publish_massqge", nullable = false, length = 200)
	public String getPublishMassqge() {
		return this.publishMassqge;
	}

	public void setPublishMassqge(String publishMassqge) {
		this.publishMassqge = publishMassqge;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "publish_date", nullable = false, length = 0)
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publish")
	public Set<Support> getSupports() {
		return this.supports;
	}

	public void setSupports(Set<Support> supports) {
		this.supports = supports;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publish")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}