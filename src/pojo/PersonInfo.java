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
 * PersonInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "personinfo", catalog = "healthcare")
public class PersonInfo implements java.io.Serializable {

	// Fields

	private Integer perinfoId;
	private Custom custom;
	private SexTable sexTable;
	private Integer perinfoAge;
	private Double perinfoWeigth;
	private Double perinfoHeight;
	private Set<Lifesign> lifesigns = new HashSet<Lifesign>(0);
	private Set<Consume> consumes = new HashSet<Consume>(0);

	// Constructors

	/** default constructor */
	public PersonInfo() {
	}

	/** minimal constructor */
	public PersonInfo(Custom custom, SexTable sexTable, Integer perinfoAge,
			Double perinfoWeigth, Double perinfoHeight) {
		this.custom = custom;
		this.sexTable = sexTable;
		this.perinfoAge = perinfoAge;
		this.perinfoWeigth = perinfoWeigth;
		this.perinfoHeight = perinfoHeight;
	}

	/** full constructor */
	public PersonInfo(Custom custom, SexTable sexTable, Integer perinfoAge,
			Double perinfoWeigth, Double perinfoHeight,
			Set<Lifesign> lifesigns, Set<Consume> consumes) {
		this.custom = custom;
		this.sexTable = sexTable;
		this.perinfoAge = perinfoAge;
		this.perinfoWeigth = perinfoWeigth;
		this.perinfoHeight = perinfoHeight;
		this.lifesigns = lifesigns;
		this.consumes = consumes;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "perinfo_id", unique = true, nullable = false)
	public Integer getPerinfoId() {
		return this.perinfoId;
	}

	public void setPerinfoId(Integer perinfoId) {
		this.perinfoId = perinfoId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "custom_id", nullable = false)
	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sex_id", nullable = true)
	public SexTable getSexTable() {
		return this.sexTable;
	}

	public void setSexTable(SexTable sexTable) {
		this.sexTable = sexTable;
	}

	@Column(name = "perinfo_age", nullable = false)
	public Integer getPerinfoAge() {
		return this.perinfoAge;
	}

	public void setPerinfoAge(Integer perinfoAge) {
		this.perinfoAge = perinfoAge;
	}

	@Column(name = "perinfo_weigth", nullable = false, precision = 6)
	public Double getPerinfoWeigth() {
		return this.perinfoWeigth;
	}

	public void setPerinfoWeigth(Double perinfoWeigth) {
		this.perinfoWeigth = perinfoWeigth;
	}

	@Column(name = "perinfo_height", nullable = false, precision = 6)
	public Double getPerinfoHeight() {
		return this.perinfoHeight;
	}

	public void setPerinfoHeight(Double perinfoHeight) {
		this.perinfoHeight = perinfoHeight;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personInfo")
	public Set<Lifesign> getLifesigns() {
		return this.lifesigns;
	}

	public void setLifesigns(Set<Lifesign> lifesigns) {
		this.lifesigns = lifesigns;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personInfo")
	public Set<Consume> getConsumes() {
		return this.consumes;
	}

	public void setConsumes(Set<Consume> consumes) {
		this.consumes = consumes;
	}

}