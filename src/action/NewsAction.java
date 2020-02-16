package action;

import java.util.List;

import pojo.News;
import pojo.Publish;
import service.NewsService;
import service.PublishService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class NewsAction implements Action {
	private NewsService newsService;
	private List<News> nlist;
	private Integer newsId;
	private News news;
	private Publish publish;
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	public List<News> getNlist() {
		return nlist;
	}

	public void setNlist(List<News> nlist) {
		this.nlist = nlist;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	public Publish getPublish() {
		return publish;
	}

	public void setPublish(Publish publish) {
		this.publish = publish;
	}

	public String shownewstitle() throws Exception {
		nlist = newsService.getAllNews();
		/*plist = publishService.getAllPublish();*/
		return SUCCESS;
	}

	public String shownews() throws Exception {
		news = newsService.getNewsById(newsId);
		ActionContext.getContext().getSession().put("news1", news);
		System.out.println(news.getNewsTitle());
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
