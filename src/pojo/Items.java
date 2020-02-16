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
 * Items entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "items", catalog = "healthcare")
public class Items implements java.io.Serializable {

	// Fields

	private Integer itmeId;
	private Custom custom;
	private Goods goods;
	private Integer itemCount;
	private Double itemPrice;
	private Date itemDate;

	// Constructors

	/** default constructor */
	public Items() {
	}

	/** full constructor */
	public Items(Custom custom, Goods goods, Integer itemCount,
			Double itemPrice, Date itemDate) {
		this.custom = custom;
		this.goods = goods;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
		this.itemDate = itemDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "itme_id", unique = true, nullable = false)
	public Integer getItmeId() {
		return this.itmeId;
	}

	public void setItmeId(Integer itmeId) {
		this.itmeId = itmeId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "custom_id")
	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "goods_id")
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Column(name = "item_count")
	public Integer getItemCount() {
		return this.itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	@Column(name = "item_price", precision = 7)
	public Double getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "item_date", length = 0)
	public Date getItemDate() {
		return this.itemDate;
	}

	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}

}