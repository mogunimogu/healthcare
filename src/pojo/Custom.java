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
 * Custom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "custom", catalog = "healthcare")
public class Custom implements java.io.Serializable {

	// Fields

	private Integer customId;
	private Role role;
	private String customName;
	private String customPwd;
	private String customEmail;
	private String customSex;
	private Set<Support> supports = new HashSet<Support>(0);
	private Set<Publish> publishs = new HashSet<Publish>(0);
	private Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>(0);
	private Set<Items> itemses = new HashSet<Items>(0);
	private Set<PersonInfo> personInfos = new HashSet<PersonInfo>(0);
	private Set<DoctorInfo> doctorInfos = new HashSet<DoctorInfo>(0);
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Custom() {
	}

	/** minimal constructor */
	public Custom(Role role, String customName, String customPwd,
			String customEmail, String customSex) {
		super();
		this.role = role;
		this.customName = customName;
		this.customPwd = customPwd;
		this.customEmail = customEmail;
		this.customSex = customSex;
	}
	
	

	public Custom(Role role, String customName, String customPwd,
			String customEmail) {
		super();
		this.role = role;
		this.customName = customName;
		this.customPwd = customPwd;
		this.customEmail = customEmail;
	}

	/** full constructor */
	public Custom(Role role, String customName, String customPwd,
			String customEmail, String customSex, Set<Support> supports,
			Set<Publish> publishs, Set<ShoppingCart> shoppingCarts,
			Set<Items> itemses, Set<PersonInfo> personInfos,
			Set<DoctorInfo> doctorInfos, Set<Reply> replies) {
		super();
		this.role = role;
		this.customName = customName;
		this.customPwd = customPwd;
		this.customEmail = customEmail;
		this.customSex = customSex;
		this.supports = supports;
		this.publishs = publishs;
		this.shoppingCarts = shoppingCarts;
		this.itemses = itemses;
		this.personInfos = personInfos;
		this.doctorInfos = doctorInfos;
		this.replies = replies;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "custom_id", unique = true, nullable = false)
	public Integer getCustomId() {
		return this.customId;
	}

	public void setCustomId(Integer customId) {
		this.customId = customId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "custom_name", nullable = false, length = 20)
	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Column(name = "custom_pwd", nullable = false, length = 20)
	public String getCustomPwd() {
		return this.customPwd;
	}

	public void setCustomPwd(String customPwd) {
		this.customPwd = customPwd;
	}
	
	@Column(name = "custom_sex", length = 4)
	public String getCustomSex() {
		return customSex;
	}

	public void setCustomSex(String customSex) {
		this.customSex = customSex;
	}

	@Column(name = "custom_email", length = 60)
	public String getCustomEmail() {
		return this.customEmail;
	}

	public void setCustomEmail(String customEmail) {
		this.customEmail = customEmail;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "custom")
	public Set<Support> getSupports() {
		return this.supports;
	}

	public void setSupports(Set<Support> supports) {
		this.supports = supports;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custom")
	public Set<Publish> getPublishs() {
		return this.publishs;
	}

	public void setPublishs(Set<Publish> publishs) {
		this.publishs = publishs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custom")
	public Set<ShoppingCart> getShoppingCarts() {
		return this.shoppingCarts;
	}

	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custom")
	public Set<Items> getItemses() {
		return this.itemses;
	}

	public void setItemses(Set<Items> itemses) {
		this.itemses = itemses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custom")
	public Set<PersonInfo> getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set<PersonInfo> personInfos) {
		this.personInfos = personInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custom")
	public Set<DoctorInfo> getDoctorInfos() {
		return this.doctorInfos;
	}

	public void setDoctorInfos(Set<DoctorInfo> doctorInfos) {
		this.doctorInfos = doctorInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custom")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", role=" + role
				+ ", customName=" + customName + ", customPwd=" + customPwd
				+ ", customEmail=" + customEmail + ", customSex=" + customSex
				+ "]";
	}
	
	

}