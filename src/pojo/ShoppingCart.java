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
 * ShoppingCart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shoppingcart", catalog = "healthcare")
public class ShoppingCart implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Custom custom;
	private Goods goods;
	private Integer SCount;
	private Double SPrice;

	// Constructors

	/** default constructor */
	public ShoppingCart() {
	}

	/** full constructor */
	public ShoppingCart(Custom custom, Goods goods, Integer SCount,
			Double SPrice) {
		this.custom = custom;
		this.goods = goods;
		this.SCount = SCount;
		this.SPrice = SPrice;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	@Column(name = "s_count")
	public Integer getSCount() {
		return this.SCount;
	}

	public void setSCount(Integer SCount) {
		this.SCount = SCount;
	}

	@Column(name = "s_price", precision = 7)
	public Double getSPrice() {
		return this.SPrice;
	}

	public void setSPrice(Double SPrice) {
		this.SPrice = SPrice;
	}

	@Override
	public String toString() {
		return "ShoppingCart [sid=" + sid + ", custom=" + custom + ", goods="
				+ goods + ", SCount=" + SCount + ", SPrice=" + SPrice + "]";
	}
	
	

}