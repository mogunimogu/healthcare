package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SexTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sextable", catalog = "healthcare")
public class SexTable implements java.io.Serializable {

	// Fields

	private Integer sexId;
	private String sex;
	private String sexImagepath;
	private Set<PersonInfo> personInfos = new HashSet<PersonInfo>(0);

	// Constructors

	/** default constructor */
	public SexTable() {
	}

	/** minimal constructor */
	public SexTable(String sex) {
		this.sex = sex;
	}

	/** full constructor */
	public SexTable(String sex, String sexImagepath, Set<PersonInfo> personInfos) {
		this.sex = sex;
		this.sexImagepath = sexImagepath;
		this.personInfos = personInfos;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "sex_id", unique = true, nullable = false)
	public Integer getSexId() {
		return this.sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}

	@Column(name = "sex", nullable = false, length = 4)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "sex_imagepath", length = 60)
	public String getSexImagepath() {
		return this.sexImagepath;
	}

	public void setSexImagepath(String sexImagepath) {
		this.sexImagepath = sexImagepath;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sexTable")
	public Set<PersonInfo> getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set<PersonInfo> personInfos) {
		this.personInfos = personInfos;
	}

}