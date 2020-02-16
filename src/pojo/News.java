package pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "healthcare")
public class News implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String newsTitle;
	private String newsType;
	private String newsContent;
	private Date newsDate;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String newsTitle, String newsType, String newsContent,
			Date newsDate) {
		this.newsTitle = newsTitle;
		this.newsType = newsType;
		this.newsContent = newsContent;
		this.newsDate = newsDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "news_id", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "news_title", nullable = false, length = 100)
	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "news_type", nullable = false, length = 50)
	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	@Column(name = "news_content", nullable = false, length = 1000)
	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "news_date", nullable = false, length = 0)
	public Date getNewsDate() {
		return this.newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

}